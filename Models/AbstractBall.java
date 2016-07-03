package Models;

import Views.Sprite;

import java.awt.image.BufferedImage;

public abstract class AbstractBall implements Ball {
    private int ballX;
    private int ballY;
    private int ballRadius;
    private int ballSpeed;
    private boolean isHit;
    private Sprite sprite;

    protected AbstractBall(int ballX, int ballY, int ballRadius, int ballSpeed, String spritePath) {
        setBallX(ballX);
        setBallY(ballY);
        setRadius(ballRadius);
        setBallSpeed(ballSpeed);
        isHit = false;
        sprite = new Sprite(spritePath, 7);
    }

    @Override
    public void move(){
        if(isHit == true){
            setBallX(getX() + (int)(0.75*ballSpeed));
            setBallY(getY() - 4*ballSpeed);
        }
    }

    @Override
    public void hitBall(){
        isHit = true;
    }

    @Override
    public boolean isHit(){
        return isHit;
    }

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

    public BufferedImage getImage() {
        return this.sprite.getImage();
    }

    protected int getBallSpeed(){ return ballSpeed; }

    protected void setBallX(int ballX){
        if (ballX < 0){
            throw new IllegalArgumentException("The X coordinate on the ball cannot be below zero");
        }
        this.ballX = ballX;
    }

    protected void setBallY(int ballY){
        this.ballY = ballY;
    }

    protected void setRadius(int ballRadius){
        if (ballY <= 0){
            throw new IllegalArgumentException("The ball radius cannot be below or equal to zero");
        }
        this.ballRadius = ballRadius;
    }

    protected void setBallSpeed(int ballSpeed){
        if (ballY <= 0) {
            throw new IllegalArgumentException("The speed of the ball cannot be below or equal to zero");
        }
        this.ballSpeed = ballSpeed;
    }
}
