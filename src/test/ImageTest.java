package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
public class ImageTest {

    @Test
    void test() {

        try {
            BufferedImage image = ImageIO.read(new File(""));
            //assert断言（判断条件是否通过）
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bullet.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //fail("Not yet implemented");
    }
}
