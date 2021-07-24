package com.zhengxuan99.tank;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    public static final int SPEED = 5;
    private boolean moving;
    private final Group group;
    private boolean live = true;


    public Player(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

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

    public void paint(Graphics g) {

        if (!this.isLive()) return;

        switch (dir) {
            case RIGHT:
                g.drawImage(ResourceMgr.GoodTankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.GoodTankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.GoodTankL, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.GoodTankD, x, y, null);
                break;
        }
        Move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
        }
        setMainDir();
    }


    private void setMainDir() {
        //all dir keys are released, tank should be stop.
        if (!bL && !bU && !bR && !bD) {
            moving = false;
        }
        //any dir key is pressed, tank should be moving;
        else {
            moving = true;

            if (bL && !bU && !bR && !bD)
                dir = Dir.LEFT;
            if (!bL && bU && !bR && !bD)
                dir = Dir.UP;
            if (!bL && !bU && !bR && bD)
                dir = Dir.DOWN;
            if (!bL && !bU && bR && !bD)
                dir = Dir.RIGHT;
        }
    }

    private void Move() {
        if (!moving) return;
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

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_CONTROL:
                fire();
                break;
        }
        setMainDir();
    }

    private void fire() {
        int bX = x + ResourceMgr.GoodTankU.getWidth() / 2 - ResourceMgr.BulletU.getWidth() / 2;
        int bY = y + ResourceMgr.GoodTankU.getHeight() / 2 - ResourceMgr.BulletU.getHeight() / 2;
        TankFrame.INSTANCE.add(new Bullets(bX, bY, this.dir,Group.GOOD));
    }

    public void die() {
        this.setLive(false);
    }
}
