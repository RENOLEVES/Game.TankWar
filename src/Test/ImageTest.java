package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

    @Test
    void test() {

        try {
            BufferedImage image = ImageIO.read(new File(""));
            //assert断言（判断条件是否通过）
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //fail("Not yet implemented");
    }
}
