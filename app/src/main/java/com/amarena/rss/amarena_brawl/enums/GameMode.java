package com.amarena.rss.amarena_brawl.enums;

public enum GameMode {

    PVP("player vs player"),
    PVB("player vs bot");

    private String name;

    GameMode(String name) {
        this.name = name;
    }
}