package Controllers;

import Models.Ball;
import Models.CurveBall;
import Models.KnuckleBall;
import Models.StraightBall;
import Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public List<Ball> ballsInPlay;
    public boolean inMenu, gameOver;
    public int currentLives;
    public int score;

    private int timer;
    private int delayBetweenShots;
    private Random random;

    public Game(){
        ballsInPlay = new ArrayList<>();
        inMenu = true;
        gameOver = false;
        currentLives = Constants.startingLives;
        score = 0;
        timer = 0;
        delayBetweenShots = Constants.startingDelayBetweenShots;
        random = new Random();
    }

    public void start(){
        while(true){
            shootBall();
            updateBalls();
            checkForMissedBalls();
            timer++;
        }
    }

    public void hitBall(){
        for (int i = 0; i < ballsInPlay.size(); i++) {
            Ball currentBall = ballsInPlay.get(i);
            if(pointIsInsideRect(new int[] {currentBall.getX(), currentBall.getY()}, Constants.playerHitbox)){
                score += Constants.pointsPerHit;
                //todo implement bounce off
                ballsInPlay.remove(i);
                i--;
            }
        }
    }

    private boolean pointIsInsideRect(int[] point, int[][] rect){
        if((point[0] >= rect[0][0] && point[0] <= rect[1][0]) &&
                (point[1] >= rect[3][1] && point[1] <= rect[0][1])){
            return true;
        }
        return false;
    }

    private void shootBall() {
        if(timer % delayBetweenShots == 0){
            int ballType = random.nextInt(4);
            Ball ball = null;
            switch(ballType) {
                case 0:
                    ball = new StraightBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(25) + 40);
                    break;
                case 1:
                    ball = new KnuckleBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(25) + 20);
                    break;
                case 2:
                    ball = new CurveBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(25) + 20);
                    break;
                case 3:
                    //todo implement danger ball
                    break;
            }
            ballsInPlay.add(ball);
        }
    }

    private void updateBalls() {
        ballsInPlay.forEach(b -> b.move());
    }

    private void checkForMissedBalls() {
        for (int i = 0; i < ballsInPlay.size(); i++) {
            if(ballsInPlay.get(i).getY() > Constants.boundaryForMiss){
                currentLives--;
                ballsInPlay.remove(i);
                i--;
            }
        }
    }

}
