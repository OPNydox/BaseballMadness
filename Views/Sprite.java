package Views;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private BufferedImage[] frames;
    private int timer, numberOfFrames;

    public Sprite(String spritePath, int numberOfFrames){
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = ImageIO.read(new File(spritePath));
        } catch (IOException ioexc){
            ioexc.printStackTrace();
        }
        timer = 0;
        this.numberOfFrames = numberOfFrames;
        frames = new BufferedImage[numberOfFrames];
        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = spriteSheet.getSubimage(i*32, 0, 32, 32);
        }
    }

    public BufferedImage getImage(){
        BufferedImage currentFrame =  frames[timer];
        timer++;
        if(timer == numberOfFrames){
            timer = 0;
        }
        return currentFrame;
    }
}
