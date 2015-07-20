public class Point  {
    static int dirX=1, dirY=1, velX=0, velY=0;

    public static void checkCollision(Ball ball) {
        Brick control = new Brick();
        control.colResponse(ball);

        Panel.paddle.colResponse(ball);
    }
}