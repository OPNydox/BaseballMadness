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
    private BufferedImage ballSprite, playerSprite_0, playerSprite_1, playerSprite_2, background;

    public DrawingPanel(Game game){
        ballsInPlay = game.ballsInPlay;
        loadResources();
    }

    private void loadResources() {
        //todo: load the res
        try{
            background = ImageIO.read(new File("src\\Resources\\background.png"));
            ballSprite = ImageIO.read(new File("Resources/ballSprite.png"));
            playerSprite_0 = ImageIO.read(new File("Resources/sprite_0.png"));
            playerSprite_0 = ImageIO.read(new File("Resources/sprite_1.png"));
            playerSprite_0 = ImageIO.read(new File("Resources/sprite_2.png"));

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
            graphics.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        }
    }
}
