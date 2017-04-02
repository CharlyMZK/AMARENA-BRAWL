package com.amarena.rss.amarena_brawl.models;

/**
 * Created by MZK on 02/03/2017.
 */
public class Attack {
    private int damages;
    private String name;
    private int criticalChance;
    private int failChance;
    private int manaCost;
    private int turnEffect;
    private int reloadTurn;

    public Attack(int damages, String name, int criticalChance, int failChance, int manaCost, int turnEffect, int reloadTurn) {
        this.damages = damages;
        this.name = name;
        this.criticalChance = criticalChance;
        this.failChance = failChance;
        this.manaCost = manaCost;
        this.turnEffect = turnEffect;
        this.reloadTurn = reloadTurn;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getTurnEffect() {
        return turnEffect;
    }

    public void setTurnEffect(int turnEffect) {
        this.turnEffect = turnEffect;
    }

    public int getReloadTurn() {
        return reloadTurn;
    }

    public void setReloadTurn(int reloadTurn) {
        this.reloadTurn = reloadTurn;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int getFailChance() {
        return failChance;
    }

    public void setFailChance(int failChance) {
        this.failChance = failChance;
    }
}
