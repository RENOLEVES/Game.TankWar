package com.zhengxuan99.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage GoodTankL,GoodTankU,GoodTankD,GoodTankR;


    static {
        try {
            GoodTankU = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("image/GoodTank.jpg")));
            GoodTankD = ImageUtil.rotateImage(GoodTankU, 180);
            GoodTankL = ImageUtil.rotateImage(GoodTankU, -90);
            GoodTankR = ImageUtil.rotateImage(GoodTankU, 90);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
