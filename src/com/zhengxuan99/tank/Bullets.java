package com.zhengxuan99.tank;

import java.awt.*;

public class Bullets {
    private static final int SPEED = 20;
    public static final int WIDTH = ResourceMgr.BulletU.getWidth();
    public static final int HEIGHT = ResourceMgr.BulletU.getHeight();
    TankFrame tf = null;

    private Dir dir;
    private int x, y;

    private boolean living = true;


    public Bullets(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.red);

        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.BulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BulletR, x, y, null);
                break;
        }

        g.setColor(c);

        move();

    }

    private void move() {
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

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public void collidewith(Enemy enemy) {
        Rectangle rect1 = new Rectangle(x,y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(enemy.getX(),enemy.getY(),Enemy.WIDTH,Enemy.HEIGHT);
        if(rect1.intersects(rect2)){
            enemy.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
