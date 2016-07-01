package Controllers;

import Models.Ball;
import Utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Ball> ballsInPlay;
    public boolean inMenu, gameOver;
    public int currentLives;
    public int score;

    private int timer;
    private int delayBetweenShots;

    public Game(){
        ballsInPlay = new ArrayList<>();
        inMenu = true;
        gameOver = false;
        currentLives = Constants.startingLives;
        score = 0;
        timer = 0;
        delayBetweenShots = Constants.startingDelayBetweenShots;
    }

    public void start(){
        while(true){
            shootBall();
            checkForMissedBalls();
            timer++;
        }
    }

    private void shootBall() {
        if(timer %)
    }
}
