package com.amarena.rss.amarena_brawl.models;

import com.amarena.rss.amarena_brawl.enums.Profession;

public class Player {

    private String nickName;
    private String password;
    private int level;
    private Profession profession;

    public Player() {
        this.nickName = "Player";
        this.password = "";
        this.level = 0;
        this.profession = Profession.WARRIOR;
    }

    public Player(String nickName, String password, int level, Profession profession) {
        this.nickName = nickName;
        this.password = password;
        this.level = level;
        this.profession = profession;
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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
