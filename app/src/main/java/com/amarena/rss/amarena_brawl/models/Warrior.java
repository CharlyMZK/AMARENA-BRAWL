package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Warrior extends Character {

    private Long id;
    private int physicalShield;

    public Warrior() {
    }

    public Warrior(int lifePoints, int manaPoints, int physicalShield) {
        super(lifePoints, manaPoints);
        this.physicalShield = physicalShield;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getPhysicalShield() {
        return physicalShield;
    }

    public void setPhysicalShield(int physicalShield) {
        this.physicalShield = physicalShield;
    }
}
