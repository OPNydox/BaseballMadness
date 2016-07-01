package Models;

import Utils.Constants;

import java.util.Random;

/**
 * Created by User on 1.7.2016 ã..
 */
public class CurveBall extends AbstractBall{
    public CurveBall(int ballX, int ballY, int ballRadius, int ballSpeed) {
        super(ballX, ballY, ballRadius, ballSpeed);
    }

    @Override
    public void move() {
        
    }

    private void findEquasion(){
        Random random = new Random();
        int a;
        int b;
        int c;

        b = (int) (Math.sqrt(Constants.pitcherX) * Constants.playerHitbox[0][1] -
                        Constants.pitcherY * Math.sqrt(Constants.playerHitbox[0][0])/
                                (Constants.playerHitbox[0][0] * Math.sqrt(Constants.pitcherX)) -
                        Constants.pitcherX*Math.sqrt(Constants.playerHitbox[0][0]));

        a = (int) ((Constants.pitcherY - b * Constants.pitcherX) / Math.sqrt(Constants.pitcherX));

        c = (int) (Constants.windowHeight/2 - a * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2) -
                        b * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2));
    }
}
