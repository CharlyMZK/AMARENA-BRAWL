package com.amarena.rss.amarena_brawl.models;

public abstract class Character {

    private Long id;
    private int maxLifePoints;
    private int maxManaPoints;
    private int currentLifePoints;
    private int currentManaPoints;

    public Character() {
    }

    public Character(int maxLifePoints, int maxManaPoints) {
        this.maxLifePoints = maxLifePoints;
        this.maxManaPoints = maxManaPoints;
        this.currentLifePoints = maxLifePoints;
        this.currentManaPoints = maxManaPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxLifePoints() {
        return maxLifePoints;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        this.maxManaPoints = maxManaPoints;
    }

    public int getCurrentLifePoints() {
        return currentLifePoints;
    }

    public void setCurrentLifePoints(int currentLifePoints) {
        this.currentLifePoints = currentLifePoints;
    }

    public int getCurrentManaPoints() {
        return currentManaPoints;
    }

    public void setCurrentManaPoints(int currentManaPoints) {
        this.currentManaPoints = currentManaPoints;
    }
}
