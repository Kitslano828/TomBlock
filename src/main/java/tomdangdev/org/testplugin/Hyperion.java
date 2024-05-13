package tomdangdev.org.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Hyperion implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            commandSender.sendMessage("Added.");
            ItemStack Hype = hyperionItem();
            ((Player) commandSender).getInventory().addItem(Hype);

            return true;
        }

        return false;
    }

    public ItemStack hyperionItem() {
        ItemStack hyperionSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta hyperionMeta = hyperionSword.getItemMeta();
        hyperionMeta.setDisplayName(ChatColor.GOLD + "Legendary Hyperion");
        ArrayList<String> hyperionLore = new ArrayList<>();
        hyperionLore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+260");
        hyperionLore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+150");
        hyperionLore.add(ChatColor.GRAY + "Intelligence " + ChatColor.GREEN + "+350");
        hyperionLore.add(ChatColor.GRAY + "Velocity: " + ChatColor.GREEN + "+30");
        hyperionLore.add("");
        hyperionLore.add("");
        hyperionLore.add(ChatColor.GRAY + "Deals +" + ChatColor.GREEN + "50%" + ChatColor.GRAY + " damage to");
        hyperionLore.add(ChatColor.GRAY + "Withers, Grant " + ChatColor.RED + "+1 Damage");
        hyperionLore.add(ChatColor.GRAY + "and " + ChatColor.GREEN + "+2" + ChatColor.AQUA + "Intelligence");
        hyperionLore.add(ChatColor.GRAY + "per " + ChatColor.RED + "Catacombs " + ChatColor.GRAY + "level");
        hyperionLore.add("");
        hyperionLore.add(ChatColor.GRAY + "Your Catacombs Level: " + ChatColor.RED + "100");
        hyperionLore.add("");
        hyperionLore.add(ChatColor.GOLD.BOLD + "LEGENDARY DUNGEON SWORD");

        hyperionMeta.setLore(hyperionLore);
        hyperionMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        hyperionMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        hyperionSword.setItemMeta(hyperionMeta);

        return hyperionSword;
    }

}