package Views;


import Controllers.Game;
import Models.Ball;
import Utils.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DrawingPanel extends JComponent {
    private List<Ball> ballsInPlay;
    private PlayerSprite playerSprite;
    private BufferedImage background;

    public DrawingPanel(Game game){
        ballsInPlay = game.ballsInPlay;
        playerSprite = game.playerSprite;
        loadResources();
    }

    private void loadResources() {
        //todo: load the res
        try{
            background = ImageIO.read(new File("src/Resources/background.png"));
        } catch (IOException ioExc){
            ioExc.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;

        graphics.drawImage(background,0,0, Constants.windowWidth, Constants.windowHeight, this);
        for (Ball ball : ballsInPlay) {
            graphics.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius(), this);
        }
        graphics.drawImage(playerSprite.getImage(), Constants.playerHitbox[3][0], Constants.playerHitbox[3][1],
                Constants.playerDimensions[0], Constants.playerDimensions[0], this);
    }
}
