package Models;

import Utils.Constants;

import java.util.Random;

/**
 * Created by User on 1.7.2016 �..
 */
public class KnuckleBall extends AbstractBall {
    private Random random;

    public KnuckleBall(int ballX, int ballY, int ballRadius, int ballSpeed, String ballSpritePath) {
        super(ballX, ballY, ballRadius, ballSpeed, ballSpritePath);
        random = new Random();
    }

    @Override
    public void move() {
        setBallY((int)(getBallSpeed() * (random.nextDouble() + 1)) + getY());
        setBallX(Constants.windowWidth/2);
        int jitter = random.nextInt(7) - 14;
        setBallX(getX() + jitter);
        super.move();
    }
}
