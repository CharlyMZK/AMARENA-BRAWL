package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Attack {

    private Long id;
    private int characterId;
    private int chosenId; // 0 if not choosen, 1 to 5 if choosen
    private int damages;
    private String name;
    private int criticalChance;
    private int failChance;
    private int manaCost;
    private int turnEffect;
    private int reloadTurn;

    public Attack() {
    }

    public Attack(int characterId, int chosenId, int damages, String name, int criticalChance, int failChance, int manaCost, int turnEffect, int reloadTurn) {
        this.characterId = characterId;
        this.chosenId = chosenId;
        this.damages = damages;
        this.name = name;
        this.criticalChance = criticalChance;
        this.failChance = failChance;
        this.manaCost = manaCost;
        this.turnEffect = turnEffect;
        this.reloadTurn = reloadTurn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getChosenId() {
        return chosenId;
    }

    public void setChosenId(int chosenId) {
        this.chosenId = chosenId;
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
