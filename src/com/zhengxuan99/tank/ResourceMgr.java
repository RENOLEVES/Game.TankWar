package com.zhengxuan99.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage GoodTankL,GoodTankU,GoodTankD,GoodTankR;
    public static BufferedImage BadTankU, BadTankD, BadTankL,BadTankR;
    public static BufferedImage BulletU,BulletD,BulletL,BulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            GoodTankU = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("image/GoodTank.jpg")));
            GoodTankD = ImageUtil.rotateImage(GoodTankU, 180);
            GoodTankL = ImageUtil.rotateImage(GoodTankU, -90);
            GoodTankR = ImageUtil.rotateImage(GoodTankU, 90);

            BadTankU = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("image/BadTank.jpg")));
            BadTankD = ImageUtil.rotateImage(BadTankU, 180);
            BadTankL = ImageUtil.rotateImage(BadTankU, -90);
            BadTankR = ImageUtil.rotateImage(BadTankU, 90);

            BulletU = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("image/Bullet.jpg")));
            BulletD = ImageUtil.rotateImage(BulletU, 180);
            BulletL = ImageUtil.rotateImage(BulletU, -90);
            BulletR = ImageUtil.rotateImage(BulletU, 90);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
