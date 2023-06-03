package org.example.UI;

import org.example.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class Icon {
    public static Optional<BufferedImage> getIcon() throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("icon.jpg");

        if (inputStream != null) {
            BufferedImage image = ImageIO.read(inputStream);

            return Optional.of(image);
        } else {
            System.out.println("File not found");
        }
        return null;
    }
}
