package com.zhengxuan99.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage GoodTankL,GoodTankU,GoodTankD,GoodTankR;


    static {
        try {
            GoodTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank.jpg"));
            GoodTankU = ImageUtil.rotateImage(GoodTankU, 180);
            GoodTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank.jpg"));
            GoodTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
