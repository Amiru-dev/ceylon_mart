package visuals;

import static gui.Login.logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum JOptionIcon {

    SUCCESS {
        @Override
        public Icon setICon() {
            try {
                InputStream imgStream = getClass().getResourceAsStream("/resourses/success.png");
                return new ImageIcon(ImageIO.read(imgStream));
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't load image", e);
            }
            return null;
        }

    }, WARNING {
        @Override
        public Icon setICon() {
            try {
                InputStream imgStream = getClass().getResourceAsStream("/resourses/warning.png");
                return new ImageIcon(ImageIO.read(imgStream));
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't load image", e);
            }
            return null;
        }

    }, INFO {
        @Override
        public Icon setICon() {
            try {
                InputStream imgStream = getClass().getResourceAsStream("/resourses/info.png");
                return new ImageIcon(ImageIO.read(imgStream));
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't load image", e);
            }
            return null;
        }

    }, QR {
        @Override
        public Icon setICon() {
            try {
                InputStream imgStream = getClass().getResourceAsStream("/resourses/qr.png");
                return new ImageIcon(ImageIO.read(imgStream));
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't load image", e);
            }
            return null;
        }

    }, ERROR {
        @Override
        public Icon setICon() {
            try {
                InputStream imgStream = getClass().getResourceAsStream("/resourses/error.png");
                return new ImageIcon(ImageIO.read(imgStream));
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't load image", e);
            }
            return null;
        }
    };

    public Icon setICon() {
        return null;
    }
}
