package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Wizard extends Character {

    private Long id;
    private int magicalShield;

    public Wizard() {
    }

    public Wizard(int lifePoints, int manaPoints, int magicalShield) {
        super(lifePoints, manaPoints);
        this.magicalShield = magicalShield;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getMagicalShield() {
        return magicalShield;
    }

    public void setMagicalShield(int magicalShield) {
        this.magicalShield = magicalShield;
    }
}
