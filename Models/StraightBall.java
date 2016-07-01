package Models;

/**
 * Created by User on 1.7.2016 �..
 */
public class StraightBall extends AbstractBall {
    public StraightBall(int ballX, int ballY, int ballRadius, int ballSpeed, String ballSpritePath) {
        super(ballX, ballY, ballRadius, ballSpeed, ballSpritePath);
    }

    @Override
    public void move() {
        super.setBallY(getY() + getBallSpeed());
    }
}
