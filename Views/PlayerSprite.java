package Views;

import Utils.Constants;

import java.awt.image.BufferedImage;

public class PlayerSprite extends Sprite{
    private boolean isHitting;
    private int timer;

    public PlayerSprite() {
        super(Constants.playerSpritePath, 3);
        timer = 0;
    }

    @Override
    public BufferedImage getImage() {
        if(isHitting){
            timer++;
        }
        if(timer == 15){
            timer = 0;
            isHitting = false;
        }
        return super.frames[timer/5];
    }

    public void playAnimation(){
        isHitting = true;
        timer = 0;
    }
}
