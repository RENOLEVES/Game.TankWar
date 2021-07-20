package com.zhengxuan99.tank;

import java.awt.*;

public class Bullets {
    private static final int SPEED = 20;
    private static final int WIDTH = 5 , HEIGHT = 10;
    private  Dir dir;
    private int x,y;

    public Bullets(int x, int y,Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
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
    }

}
