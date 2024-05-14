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
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import java.util.HashMap;
import java.util.Map;

public class ghost implements CommandExecutor, Listener {

    private Plugin plugin;
    private Map<Creeper, Scoreboard> creeperScoreboards;

    public ghost(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        creeperScoreboards = new HashMap<>();
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

            // Display health above the Creeper
            displayHealthAboveEntity((Player) commandSender, ghostCreeper, ghostCreeper.getHealth());

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

            // Update displayed health above the Creeper
            if (event.getDamager() instanceof Player) {
                updateHealthAboveEntity((Player) event.getDamager(), creeper, newHealth);
            }
        }
    }

    private void displayHealthAboveEntity(Player player, Creeper creeper, double health) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("health", "dummy", "Health");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        Score score = objective.getScore(creeper.getName());
        score.setScore((int) health);
        player.setScoreboard(scoreboard);
        creeperScoreboards.put(creeper, scoreboard);
    }

    private void updateHealthAboveEntity(Player player, Creeper creeper, double health) {
        Scoreboard scoreboard = creeperScoreboards.get(creeper);
        if (scoreboard != null) {
            Objective objective = scoreboard.getObjective("health");
            if (objective != null) {
                Score score = objective.getScore(creeper.getName());
                score.setScore((int) health);
            }
        }
    }
}
