package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Result {

    private Long id;
    private Player player;
    private Character character;
    private int victoriesPvp;
    private int victoriesPvc;
    private int defeatsPvp;
    private int defeatsPvc;

    public Result() {
    }

    public Result(Player player, Character character, int victoriesPvp, int victoriesPvc, int defeatsPvp, int defeatsPvc) {
        this.player = player;
        this.character = character;
        this.victoriesPvp = victoriesPvp;
        this.victoriesPvc = victoriesPvc;
        this.defeatsPvp = defeatsPvp;
        this.defeatsPvc = defeatsPvc;
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

    public int getVictoriesPvp() {
        return victoriesPvp;
    }

    public void setVictoriesPvp(int victoriesPvp) {
        this.victoriesPvp = victoriesPvp;
    }

    public int getVictoriesPvc() {
        return victoriesPvc;
    }

    public void setVictoriesPvc(int victoriesPvc) {
        this.victoriesPvc = victoriesPvc;
    }

    public int getDefeatsPvp() {
        return defeatsPvp;
    }

    public void setDefeatsPvp(int defeatsPvp) {
        this.defeatsPvp = defeatsPvp;
    }

    public int getDefeatsPvc() {
        return defeatsPvc;
    }

    public void setDefeatsPvc(int defeatsPvc) {
        this.defeatsPvc = defeatsPvc;
    }
}
