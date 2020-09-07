import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Dibujo {
    private BufferedImage imagen;
    private Integer posX;
    private Integer posY;

    public Dibujo() {
        try {
            imagen = ImageIO.read(new File("src/zebra.png"));
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
        setPosX(200);
        setPosY(200);
    }

    public Integer getAncho () {
        return imagen.getWidth();
    }

    public Integer getAlto () {
        return imagen.getHeight();
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

}
