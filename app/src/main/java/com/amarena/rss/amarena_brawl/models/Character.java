package com.amarena.rss.amarena_brawl.models;

import java.util.List;

/**
 * Created by MZK on 02/03/2017.
 */
public class Character extends Sprite {
    private int lifePoints;
    private int manaPoints;
    private static List<Attack> everyAttacks;

    public Character(String image, int x, int y, int speedX, int speedY, int lifePoints, int manaPoints) {
        super(image, x, y, speedX, speedY);
        this.lifePoints = lifePoints;
        this.manaPoints = manaPoints;
    }


    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public static List<Attack> getEveryAttacks() {
        return everyAttacks;
    }

    public static void setEveryAttacks(List<Attack> everyAttacks) {
        Character.everyAttacks = everyAttacks;
    }
}
