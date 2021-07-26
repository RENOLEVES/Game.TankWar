package com.zhengxuan99.tank;

import java.awt.*;
import java.util.Random;

public class Enemy {
    private Dir dir;
    private int x, y;
    TankFrame tf = null;
    private Random random = new Random();
    public static final int WIDTH = ResourceMgr.BadTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.BadTankD.getHeight();
    private boolean living = true;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.living = false;
    }

    public Enemy(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        if (!living) return;
        g.drawImage(ResourceMgr.BadTankD, x, y, null);
    }
}
