package Models;

/**
 * Created by User on 1.7.2016 ã..
 */
public abstract class AbstractBall implements Ball {
    private int ballX;
    private int ballY;
    private int ballRadius;
    private int ballSpeed;

    public AbstractBall(int ballX, int ballY, int ballRadius, int ballSpeed) {
        this.ballX = ballX;
        this.ballY = ballY;
        this.ballRadius = ballRadius;
        this.ballSpeed = ballSpeed;
    }

    @Override
    public abstract void move();

    @Override
    public int getX() {
        return ballX;
    }

    @Override
    public int getY() {
        return ballY;
    }

    @Override
    public int getRadius() {
        return ballRadius;
    }

    @Override
    public int getBallSpeed() {
        return ballSpeed;
    }

    private void setX(int ballX){
        if (ballX < 0){
            throw new IllegalArgumentException("The X coordinate on the ball cannot be below zero");
        }
        this.ballX = ballX;
    }

    private void setBallY(int ballY){
        if (ballY < 0){
            throw new IllegalArgumentException("The X coordinate on the ball cannot be below zero");
        }
        this.ballY = ballY;
    }

    private void setRadius(int ballRadius){
        if (ballY <= 0){
            throw new IllegalArgumentException("The ball radius cannot be below or equal to zero");
        }
        this.ballRadius = ballRadius;
    }

    private void setBallSpeed(int ballSpeed){
        if (ballY <= 0) {
            throw new IllegalArgumentException("The speed of the ball cannot be below or equal to zero");
        }
        this.ballSpeed = ballSpeed;
    }
}
