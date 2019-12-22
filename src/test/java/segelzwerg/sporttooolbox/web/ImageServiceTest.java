package segelzwerg.sporttooolbox.web;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

class ImageServiceTest {

    private BufferedImage image;
    private ImageService imageService;

    @BeforeEach
    void setUp() {
        image = null;
        File resources = new File("src/test/resources");
        try {
            image = ImageIO.read(new FileInputStream(resources.getAbsolutePath() + "/heatmap-file.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageService = new ImageService();
    }

    @Test
    void getImageBytes_test() throws IOException {
        byte[] imageBytes = imageService.getImageBytes(image);
        assertThat(imageBytes, IsNull.notNullValue());
    }
}