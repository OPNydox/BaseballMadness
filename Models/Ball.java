package Models;

import java.awt.image.BufferedImage;

/**
 * Created by User on 1.7.2016 �..
 */
public interface Ball {
    void move();
    void hitBall();
    boolean isHit();
    int getX();
    int getY();
    int getRadius();
    BufferedImage getImage();
}
