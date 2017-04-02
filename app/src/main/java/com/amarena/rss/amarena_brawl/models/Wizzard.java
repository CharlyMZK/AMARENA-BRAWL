package com.amarena.rss.amarena_brawl.models;

/**
 * Created by MZK on 02/03/2017.
 */
public class Wizzard extends Character {
    int magicalShield;

    public Wizzard(String image, int x, int y, int speedX, int speedY, int lifePoints, int manaPoints, int magicalShield) {
        super(image, x, y, speedX, speedY, lifePoints, manaPoints);
        this.magicalShield = magicalShield;
    }

    public int getMagicalShield() {
        return magicalShield;
    }

    public void setMagicalShield(int magicalShield) {
        this.magicalShield = magicalShield;
    }
}
