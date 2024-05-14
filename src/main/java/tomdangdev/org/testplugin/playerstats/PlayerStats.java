package tomdangdev.org.testplugin.playerstats;

import java.util.Random;

public class PlayerStats {

    private int damage, strength, speed, criticalChance,
                mana, miningSpeed, miningFortune, farmingFortune,
                lootFind;

    // Player Object
    public PlayerStats() {
        this.damage = 20;
        this.strength = 5;
        this.speed = 20;
        this.criticalChance = 1;
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
    public int getCriticalChance() { return criticalChance; }
    public int getMana() { return mana; }
    public int getMiningSpeed() { return miningSpeed; }
    public int getMiningFortune() { return miningFortune; }
    public int getFarmingFortune() { return farmingFortune; }
    public int getLootFind() { return lootFind; }

    // setting player stats
    public void setDamage(int damage) {this.damage = damage;}
    public void setStrength(int strength) {this.strength = strength;}
    public void setSpeed(int speed) {this.speed = speed;}
    public void setCriticalChance(int criticalChance) {this.criticalChance = criticalChance;}
    public void setMana(int mana) {this.mana = mana;}
    public void setMiningSpeed (int miningSpeed) {this.miningSpeed = miningSpeed;}
    public void setMiningFortune (int miningFortune) {this.miningFortune = miningFortune;}
    public void setFarmingFortune (int farmingFortune) {this.farmingFortune = farmingFortune;}
    public void setLootFind (int lootFind) {this.lootFind = lootFind;}

}
