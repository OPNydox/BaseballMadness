package Views;

import Controllers.Game;
import Utils.Constants;
import Utils.RepaintTheWindow;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame {
    public Window(Game game){
        super(Constants.title);
        setSize(Constants.windowWidth, Constants.windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel(game);

        drawingPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1){
                    game.hitBall();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        executor.scheduleAtFixedRate(new RepaintTheWindow(this), 0L, 16L, TimeUnit.MILLISECONDS);

        this.add(drawingPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
