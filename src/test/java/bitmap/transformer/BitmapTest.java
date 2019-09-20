package bitmap.transformer;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitmapTest {
    String fileIn = "/Users/jamesdansie/codefellows/401/bitmap-transformer/src/main/resources/stuff.bmp";
    @Test
    public void flipHoriz() {
        assertTrue(
                "If the method is successful, will return true",
                new Bitmap(fileIn).flipHoriz("test.bmp")
        );
    }

    @Test
    public void flipVert() {
        assertTrue(
                "If the method is successful, will return true",
                new Bitmap(fileIn).flipVert("test.bmp")
        );
    }

    @Test
    public void tiedye() {
        assertTrue(
                "If the method is successful, will return true",
                new Bitmap(fileIn).tiedye("test.bmp")
        );
    }
}