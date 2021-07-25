package com.zhengxuan99.tank;

import java.awt.*;

public class Bullets {
    private static final int SPEED = 20;
    private static final int WIDTH = 5 , HEIGHT = 5;
    TankFrame tf = null;

    private  Dir dir;
    private int x,y;

    private boolean live = true;

    public Bullets(int x, int y,Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH, HEIGHT);
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

            if(x<0 || y<0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
                live = false;
            }
    }

}
