package Models;

import Utils.Constants;

import java.util.Random;

/**
 * Created by User on 1.7.2016 ã..
 */
public class CurveBall extends AbstractBall{

    private int a;
    private double b;
    private double c;

    public CurveBall(int ballX, int ballY, int ballRadius, int ballSpeed, String ballSpritePath) {
        super(ballX, ballY, ballRadius, ballSpeed, ballSpritePath);
        findEquasion();
    }

    @Override
    public void move() {
        setBallY(getY() + getBallSpeed());
        setBallX((int) (Constants.windowWidth/2*(2/3) - Math.sqrt(Math.sqrt(Constants.windowWidth/2*(2/3)) -
                Math.sqrt(Constants.windowHeight)) - getX()));
    }

    private void findEquasion(){
        Random random = new Random();

        switch (random.nextInt(2)){
            case 0:
                b =  (Math.sqrt(Constants.pitcherX) * Constants.playerHitbox[0][1] -
                        Constants.pitcherY * Math.sqrt(Constants.playerHitbox[0][0])/
                                (Constants.playerHitbox[0][0] * Math.sqrt(Constants.pitcherX)) -
                        Constants.pitcherX*Math.sqrt(Constants.playerHitbox[0][0]));

                //a =  ((Constants.pitcherY - b * Constants.pitcherX) / Math.sqrt(Constants.pitcherX));

                c = (Constants.windowHeight/2 - a * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2) -
                        b * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2));
                break;
            case 1:
                b =  (Math.sqrt(Constants.pitcherX) * Constants.playerHitbox[0][1] -
                        Constants.pitcherY * Math.sqrt(Constants.playerHitbox[0][0])/
                                (Constants.playerHitbox[0][0] * Math.sqrt(Constants.pitcherX)) -
                        Constants.pitcherX*Math.sqrt(Constants.playerHitbox[0][0]));

               // a =  ((Constants.pitcherY - b * Constants.pitcherX) / Math.sqrt(Constants.pitcherX)) * (-1);

                c = (Constants.windowHeight/2 - a * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2) -
                        b * Math.sqrt(random.nextInt(Constants.windowWidth/2) + Constants.windowWidth/2));
                break;
        }

    }
}
