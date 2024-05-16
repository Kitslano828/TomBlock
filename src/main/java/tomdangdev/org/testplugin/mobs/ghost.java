package tomdangdev.org.testplugin.mobs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class ghost implements CommandExecutor, Listener {

    private Plugin plugin;

    public ghost(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Location playerLocation = ((Player) commandSender).getLocation();
            Location spawnLocation = playerLocation.clone().add(0, 1, 0);

            Creeper ghostCreeper = (Creeper) playerLocation.getWorld().spawnEntity(spawnLocation, EntityType.CREEPER);

            ghostCreeper.setInvisible(true);

            ghostCreeper.setPowered(true);


            // Set initial health to 1 million
            ghostCreeper.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000);
            ghostCreeper.setHealth(ghostCreeper.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

            return true;
        }

        return false;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Creeper) {
            Creeper creeper = (Creeper) event.getEntity();
            double currentHealth = creeper.getHealth();
            double damage = event.getDamage();

            // Update Creeper's health after taking damage
            double newHealth = Math.max(0, currentHealth - damage);
            creeper.setHealth(newHealth);
        }
    }
}
