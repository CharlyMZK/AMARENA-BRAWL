package com.amarena.rss.amarena_brawl.models;

import com.orm.dsl.Table;

@Table
public class Sprite {

    private Long id;
    private String image;
    private int X;
    private int Y;
    private int SpeedX;
    private int SpeedY;

    public Sprite() {
    }

    public Sprite(String image, int x, int y, int speedX, int speedY) {
        this.image = image;
        X = x;
        Y = y;
        SpeedX = speedX;
        SpeedY = speedY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getSpeedX() {
        return SpeedX;
    }

    public void setSpeedX(int speedX) {
        SpeedX = speedX;
    }

    public int getSpeedY() {
        return SpeedY;
    }

    public void setSpeedY(int speedY) {
        SpeedY = speedY;
    }
}
