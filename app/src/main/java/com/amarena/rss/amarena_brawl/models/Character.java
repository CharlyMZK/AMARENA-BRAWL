package com.amarena.rss.amarena_brawl.models;

public abstract class Character {

    private Long id;
    private int lifePoints;
    private int manaPoints;

    public Character() {
    }

    public Character(int lifePoints, int manaPoints) {
        this.lifePoints = lifePoints;
        this.manaPoints = manaPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
