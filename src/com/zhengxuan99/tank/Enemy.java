package com.zhengxuan99.tank;

import java.awt.*;

public class Enemy {
    private Dir dir;
    private int x, y;
    TankFrame tf = null;

    public Enemy(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.BadTankD,x,y,null);
    }
}
