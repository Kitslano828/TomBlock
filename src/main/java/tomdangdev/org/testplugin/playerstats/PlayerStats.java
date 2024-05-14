package tomdangdev.org.testplugin.playerstats;

import java.util.Random;

public class PlayerStats {

    private int damage, strength, speed, critChance,
                mana, miningSpeed, miningFortune, farmingFortune,
                lootFind;

    // Player Object
    public PlayerStats() {
        this.damage = 20;
        this.strength = 5;
        this.speed = 20;
        this.critChance = 1;
        this.mana = 100;
        this.miningSpeed = 20;
        this.miningFortune = 0;
        this.farmingFortune = 0;
        this.lootFind = 5;
    }

    // getting player stats
    public int getDamage() {
        return damage;
    }
    public int getStrength() { return strength; }
    public int getSpeed() { return speed; }
    public int getCritChance() { return critChance; }
    public int getMana() { return mana; }
    public int getMiningSpeed() { return miningSpeed; }
    public int getMiningFortune() { return miningFortune; }
    public int getFarmingFortune() { return farmingFortune; }
    public int getLootFind() { return lootFind; }

}
