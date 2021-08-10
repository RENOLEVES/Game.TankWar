package com.zhengxuan99.tank;

import java.awt.*;

public class Bullets {
    private static final int SPEED = 20;
    public static final int WIDTH = ResourceMgr.BulletU.getWidth();
    public static final int HEIGHT = ResourceMgr.BulletU.getHeight();
    TankFrame tf = null;

    Rectangle rect = new Rectangle();

    private Dir dir;
    private int x, y;

    private boolean living = true;
    private Group group = Group.BAD;


    public Bullets(int x, int y, Dir dir, Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
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

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    public void collidewith(Enemy enemies) {
        if(this.group == enemies.getGroup()) return;

        //TODO:用一个rect来记录子弹的位置
        Rectangle rect1 = new Rectangle(x,y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(enemies.getX(),enemies.getY(),Enemy.WIDTH,Enemy.HEIGHT);
        if(rect1.intersects(rect2)){
            enemies.die();
            this.die();
        }
    }
    public void collidewith(Tank mytank) {
        if(this.group == mytank.getGroup()) return;

        //TODO:用一个rect来记录子弹的位置
        Rectangle rect1 = new Rectangle(x,y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(mytank.getX(),mytank.getY(),Enemy.WIDTH,Enemy.HEIGHT);
        if(rect1.intersects(rect2)){
            mytank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
