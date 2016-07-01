package Utils;

public class Constants {
    public static int windowHeight = 600;
    public static int windowWidth = 300;

    public static int[][] playerHitbox = {
            {100, 500}, {200, 500}, {200, 400}, {100, 400}
    };

    public static int boundaryForMiss = 500;

    public static int pitcherX = windowWidth/2, pitcherY = 20;

    public static int startingLives = 3;
    public static int pointsPerHit = 500;

    public static int startingDelayBetweenShots = 180;

    public static int ballRadius = 20;

    public static String title = "Baseball Madness";

    public static String ballSpritePath = "src/Resources/ballSprite.png";
}
