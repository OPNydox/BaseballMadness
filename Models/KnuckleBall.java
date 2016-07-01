package Models;

import java.util.Random;

/**
 * Created by User on 1.7.2016 ã..
 */
public class KnuckleBall extends AbstractBall {
    private Random random;

    public KnuckleBall(int ballX, int ballY, int ballRadius, int ballSpeed) {
        super(ballX, ballY, ballRadius, ballSpeed);
        random = new Random();
    }

    @Override
    public void move() {
        setBallY((int)(getBallSpeed() * (random.nextDouble() + 1)) + getY());
    }
}
