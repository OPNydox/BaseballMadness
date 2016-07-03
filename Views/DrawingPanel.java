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
    private Game game;
    private BufferedImage background;
    private Font font;

    public DrawingPanel(Game game){
        loadResources();
        ballsInPlay = game.ballsInPlay;
        playerSprite = game.playerSprite;
        this.game = game;
        font = new Font("Symtext", Font.PLAIN, 25);
    }

    private void loadResources() {
        //todo: load the res
        try{
            background = ImageIO.read(new File("src/Resources/background.png"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Resources/Symtext.ttf")));
            //font = Font.createFont(Font.PLAIN, new File("src/Resources/Symtext.ttf"));
        } catch (IOException|FontFormatException exc){
            exc.printStackTrace();
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
        graphics.drawImage(playerSprite.getImage(), Constants.playerPosition[0], Constants.playerPosition[1],
                Constants.playerDimensions[0], Constants.playerDimensions[0], this);

        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        graphics.drawString("SCORE: " + game.score, 2, 24);

        Toolkit.getDefaultToolkit().sync();
    }
}
