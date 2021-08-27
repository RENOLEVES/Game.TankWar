package com.zhengxuan99.tank;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;


public class Tank {
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

    int x, y;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 6;

    Rectangle rect = new Rectangle();

    public static final int WIDTH = ResourceMgr.GoodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.GoodTankU.getHeight();

    private boolean moving = false;
    TankFrame tf = null;
    private boolean living = true;

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    Group group = Group.BAD;

    FireStrategy fs;

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

    public void die() {
        this.living = false;
    }


    public Tank(int x, int y, Dir dir, Group group , TankFrame tf) {
        super();
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

    public void fire() {

        fs.fire(this);
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

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

        private void boundsCheck() {
            if (x < 12) x = 12;
            if (y < 34) y = 34;
            if (x > TankFrame.GAME_WIDTH - ResourceMgr.GoodTankU.getWidth() -12)
                x = TankFrame.GAME_WIDTH -  ResourceMgr.GoodTankU.getWidth() -12;
            if (y > TankFrame.GAME_HEIGHT - ResourceMgr.GoodTankU.getHeight()-12)
                y = TankFrame.GAME_HEIGHT - ResourceMgr.GoodTankU.getHeight()-12;
        }

}
