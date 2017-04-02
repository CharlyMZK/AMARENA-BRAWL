package com.amarena.rss.amarena_brawl.models;

/**
 * Created by MZK on 02/03/2017.
 */
public class Player {
    private String nickName;
    private String password;
    private int level;
    private Character character;

    public Player(String nickName, String password, int level, Character character) {
        this.nickName = nickName;
        this.password = password;
        this.level = level;
        this.character = character;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
