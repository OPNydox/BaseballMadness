package Controllers;

import Models.Ball;
import Models.CurveBall;
import Models.KnuckleBall;
import Models.StraightBall;
import Utils.Constants;
import Views.PlayerSprite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public List<Ball> ballsInPlay;
    public boolean inMenu, gameOver;
    public int currentLives;
    public int score;
    public PlayerSprite playerSprite;

    private int timer;
    private int delayBetweenShots;
    private int baseSpeed;
    private Random random;

    public Game(){
        ballsInPlay = new ArrayList<>();
        inMenu = true;
        gameOver = false;
        currentLives = Constants.startingLives;
        score = 0;
        baseSpeed = 5;
        playerSprite = new PlayerSprite();

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
            if(timer % 30 == 0 && delayBetweenShots > 45){
                delayBetweenShots--;
            }
            if(timer % 60 == 0 && baseSpeed < 8){
                baseSpeed++;
            }
            try{
                Thread.sleep(15);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public void hitBall(){
        playerSprite.playAnimation();
        for (int i = 0; i < ballsInPlay.size(); i++) {
            Ball currentBall = ballsInPlay.get(i);
            if(pointIsInsideRect(new int[] {currentBall.getX(), currentBall.getY()}, Constants.playerHitbox)){
                score += Constants.pointsPerHit;
                //todo implement bounce off
                currentBall.hitBall();
            }
            else {
                score -= 111;
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
            int ballType = random.nextInt(3); //CHANGE TO 4 to implement danger ball
            Ball ball = null;
            switch(ballType) {
                case 0:
                    ball = new StraightBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(baseSpeed) + 5, Constants.ballSpritePath);
                    break;
                case 1:
                    ball = new KnuckleBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(baseSpeed) + 4, Constants.ballSpritePath);
                    break;
                case 2:
                    ball = new CurveBall(Constants.pitcherX, Constants.pitcherY,
                            Constants.ballRadius, random.nextInt(baseSpeed) + 3, Constants.ballSpritePath);
                    break;
            }
            ballsInPlay.add(ball);
        }
    }

    private void updateBalls() {
        for (int i = 0; i < ballsInPlay.size(); i++) {
            ballsInPlay.get(i).move();
        }
    }

    private void checkForMissedBalls() {
        boolean removeHappened = false;
        for (int i = 0; i < ballsInPlay.size(); i++) {
            if(ballsInPlay.get(i).getY() > Constants.boundaryForMiss){
                currentLives--;
                score -= 750;
                removeHappened = true;
            }
            if(ballsInPlay.get(i).getY() <= 0 && ballsInPlay.get(i).isHit()){
                removeHappened = true;
            }
            if(removeHappened){
                ballsInPlay.remove(i);
                i--;
                removeHappened = false;
            }
        }
    }

}
