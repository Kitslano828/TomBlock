package tomdangdev.org.testplugin.playerstats;

import org.bukkit.Color;

import java.util.ArrayList;

public class WeaponStats {

    int damage;
    int strength;
    int critChance;
    int mana;
    int speed;

    ArrayList<String> weaponLore = new ArrayList<>();

    public WeaponStats(int damage, int strength, int critChance, int mana, int speed) {
        this.damage = damage;
        this.strength = strength;
        this.critChance = critChance;
        this.mana = mana;
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
        weaponLore.add(Color.GRAY + "Damage: " + Color.RED + damage);
    }

    public void setStrength(int strength) {
        this.strength = strength;
        weaponLore.add(Color.GRAY + "Strength: " + Color.RED + strength);
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
        weaponLore.add(Color.GRAY + "Critical Chance: " + Color.YELLOW + "+ " + critChance + "%");
    }

    public void setMana(int mana) {
        this.mana = mana;
        weaponLore.add(Color.GRAY + "Mana: " + Color.BLUE + mana);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        weaponLore.add(Color.GRAY + "Speed: " + Color.GREEN + speed);
    }

    public ArrayList<String> getWeaponLore() {
        return weaponLore;
    }
}
