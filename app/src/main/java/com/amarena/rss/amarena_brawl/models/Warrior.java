package com.amarena.rss.amarena_brawl.models;

/**
 * Created by MZK on 02/03/2017.
 */
public class Warrior extends Character{
    int physicalShield;

    public Warrior(String image, int x, int y, int speedX, int speedY, int lifePoints, int manaPoints, int physicalShield) {
        super(image, x, y, speedX, speedY, lifePoints, manaPoints);
        this.physicalShield = physicalShield;
    }

    public int getPhysicalShield() {
        return physicalShield;
    }

    public void setPhysicalShield(int physicalShield) {
        this.physicalShield = physicalShield;
    }
}
