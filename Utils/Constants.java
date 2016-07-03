package Utils;

public class Constants {
    public static int windowHeight = 600;
    public static int windowWidth = 300;

    public static int[][] playerHitbox = {
            {75, 525}, {225, 525}, {225, 400}, {75, 400}
    };

    public static int[] playerDimensions = {100,250};

    public static int[] playerPosition = {100, 425};

    public static int boundaryForMiss = 550;

    public static int pitcherX = windowWidth/2, pitcherY = 20;

    public static int startingLives = 3;
    public static int pointsPerHit = 500;

    public static int startingDelayBetweenShots = 130;

    public static int ballRadius = 20;

    public static String title = "Baseball Madness";

    public static String ballSpritePath = "src/Resources/ballSprite.png";
    public static String playerSpritePath = "src/Resources/playerSpriteSheet.png";
}
