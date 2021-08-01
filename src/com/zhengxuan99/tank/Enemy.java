package com.zhengxuan99.tank;

import java.awt.*;
import java.util.Random;

public class Enemy {
    private Dir dir;
    private int x, y;
    private int SPEED = 6;

    TankFrame tf = null;
    Rectangle rect = new Rectangle();

    private Random random = new Random();
    public static final int WIDTH = ResourceMgr.BadTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.BadTankD.getHeight();
    private boolean living = true;
    private boolean moving = true;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group = Group.BAD;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void die() {
        this.living = false;
    }

    public Enemy(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void move() {
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

        if (random.nextInt(100) > 95) this.enemyfire();
        randomDir();
        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (x < 12) x = 12;
        if (y < 34) y = 34;
        if (x > TankFrame.GAME_WIDTH - ResourceMgr.BadTankU.getWidth()-12)
            x = TankFrame.GAME_WIDTH -  ResourceMgr.BadTankU.getWidth()-12;
        if (y > TankFrame.GAME_HEIGHT - ResourceMgr.BadTankU.getHeight()-12)
            y = TankFrame.GAME_HEIGHT - ResourceMgr.BadTankU.getHeight()-12;
    }

    private void randomDir() {
        if (random.nextInt(100) > 80)
            this.dir = Dir.values()[random.nextInt(4)];
    }


    public void paint(Graphics g) {
        if (!living) tf.enemies.remove(this);
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.BadTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BadTankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BadTankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BadTankL, x, y, null);
                break;

        }

        move();


    }

    public void enemyfire() {
        int bX = this.x + Enemy.WIDTH / 2 - Bullets.WIDTH / 2;
        int bY = this.y + Enemy.HEIGHT / 2 - Bullets.HEIGHT / 2;
        tf.bullets.add(new Bullets(bX, bY, this.dir, this.group, this.tf));
    }
}
