package com.zhengxuan99.tank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));

        for (int i = 0; i < initTankCount; i++) {
            tf.enemies.add(new Enemy(30+ i*70,100,Dir.DOWN,Group.BAD,tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
