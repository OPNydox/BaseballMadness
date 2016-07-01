package Models;

/**
 * Created by User on 1.7.2016 ã..
 */
public class StraightBall extends AbstractBall {
    public StraightBall(int ballX, int ballY, int ballRadius, int ballSpeed) {
        super(ballX, ballY, ballRadius, ballSpeed);
    }

    @Override
    public void move() {
        super.setBallY(getY() + getBallSpeed());
    }
}
