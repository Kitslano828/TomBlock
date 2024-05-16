package tomdangdev.org.testplugin.items;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tomdangdev.org.testplugin.playerstats.WeaponStats;

import java.util.ArrayList;

public class firstCustomSword implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            // Create an instance of WeaponStats
            WeaponStats newSword = new WeaponStats(10, 5, 20, 50, 2); // Example stats

            // Create ItemStack for the custom sword
            ItemStack firstSword = new ItemStack(Material.IRON_SWORD);
            ItemMeta swordMeta = firstSword.getItemMeta();

            // Apply custom stats lore to the ItemMeta
            if (swordMeta != null) {
                // Set the lore generated from WeaponStats
                swordMeta.setLore(newSword.getWeaponLore());
                firstSword.setItemMeta(swordMeta);

                // Give the custom sword to the player
                player.getInventory().addItem(firstSword);
            }
        }
        return true; // Return true if the command was executed successfully
    }
}