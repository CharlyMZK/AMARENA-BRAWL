package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Config {

    private Long id;
    private Player player;
    private Character character;

    public Config() {
    }

    public Config(Player player, Character character) {
        this.player = player;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}