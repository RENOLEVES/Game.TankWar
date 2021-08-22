package com.zhengxuan99.tank;

public class FourDirFireStrategy implements FireStrategy{


    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullets.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullets.HEIGHT/2;

        Dir[] dirs= Dir.values();
        for(Dir dir : dirs) {
            new Bullets(bX, bY, dir, t.group, t.tf);
        }
    }
}
