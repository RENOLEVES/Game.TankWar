package com.zhengxuan99.tank;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullets.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullets.HEIGHT/2;

        new Bullets( bX, bY, t.dir ,t.group, t.tf);
    }
}
