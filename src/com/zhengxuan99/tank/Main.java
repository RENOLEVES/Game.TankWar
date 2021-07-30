package com.zhengxuan99.tank;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tf.enemies.add(new Enemy(50+ i*150,100,Dir.DOWN,Group.BAD,tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
