package com.amarena.rss.amarena_brawl.models;

/**
 * Created by MZK on 02/03/2017.
 */
public class Archer extends Character{
    int dodgeChance;

    public Archer(String image, int x, int y, int speedX, int speedY, int lifePoints, int manaPoints, int dodgeChance) {
        super(image, x, y, speedX, speedY, lifePoints, manaPoints);
        this.dodgeChance = dodgeChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

}
