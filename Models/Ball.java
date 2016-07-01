package Models;

import java.awt.image.BufferedImage;

/**
 * Created by User on 1.7.2016 �..
 */
public interface Ball {
    void move();
    int getX();
    int getY();
    int getRadius();
    BufferedImage getImage();
}
