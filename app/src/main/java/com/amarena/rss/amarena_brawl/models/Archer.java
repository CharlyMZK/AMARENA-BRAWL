package com.amarena.rss.amarena_brawl.models;


import com.orm.dsl.Table;

@Table
public class Archer extends Character {

    private Long id;
    private int dodgeChance;

    public Archer() {
    }

    public Archer(int lifePoints, int manaPoints, int dodgeChance) {
        super(lifePoints, manaPoints);
        this.dodgeChance = dodgeChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
