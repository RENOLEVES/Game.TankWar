package com.zhengxuan99.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public static final int WIDTH = ResourceMgr.GoodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.GoodTankU.getHeight();

    private boolean moving = false;
    private TankFrame tf = null;


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public Tank(int x, int y, Dir dir, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.GoodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.GoodTankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.GoodTankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.GoodTankL, x, y, null);
                break;

        }


        move();
    }

    private void move() {
        if (!moving) return;
        else {
            switch (dir) {
                case LEFT:
                    x -= SPEED;
                    break;
                case UP:
                    y -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
            }
        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullets.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullets.HEIGHT/2;
        tf.bullets.add(new Bullets( bX, bY, this.dir , this.tf));
    }


}
