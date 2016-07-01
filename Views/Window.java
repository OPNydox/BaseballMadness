package Views;

import Controllers.Game;
import Utils.Constants;
import Utils.RepaintTheWindow;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame {
    public Window(Game game){
        super(Constants.title);
        setSize(Constants.windowWidth, Constants.windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel(game);

        drawingPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    game.hitBall();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        executor.scheduleAtFixedRate(new RepaintTheWindow(this), 0L, 16L, TimeUnit.MILLISECONDS);

        this.add(drawingPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
