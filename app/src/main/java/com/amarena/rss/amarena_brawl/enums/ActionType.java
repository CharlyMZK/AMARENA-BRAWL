package com.amarena.rss.amarena_brawl.enums;


public enum ActionType {

    PHYSICALDAMAGE("physical damage"),
    MAGICALDAMAGE("magical damage"),
    HEAL("heal"),
    PHYSICALSHIELD("physical shield"),
    MAGICALSHIELD("magicalShield");

    private String name;

    ActionType(String name) {
        this.name = name;
    }
}
