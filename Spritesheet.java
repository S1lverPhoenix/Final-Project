import java.awt.image.BufferedImage;
public class Spritesheet {

    public BufferedImage spriteSheet;
    public Spritesheet(BufferedImage b){
        this.spriteSheet =b;     
    }

    public BufferedImage getSprite(int x, int y, int width, int height){
        BufferedImage sprite = spriteSheet.getSubimage(x, y, width, heigth);
        return sprite;

    }

}