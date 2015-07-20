public class Point  {
    static int dirX=1, dirY=1, velX=0, velY=0;

    public static void checkCollision(Ball ball) {
        Brick control = new Brick();
        control.colResponse(ball);
        Panel.paddle.colResponse(ball);

        if(dirX==1) {
            if(dirY==1) {
                ball.setX(ball.getX() + dirX + Math.abs(velX));
                ball.setY(ball.getY() + dirY + Math.abs(velY));
            }
            else {
                ball.setX(ball.getX() + dirX + Math.abs(velX));
                ball.setY(ball.getY() + dirY - Math.abs(velY));
            }
        }
        else if(dirX==-1) {
            if(dirY==1) {
                ball.setX(ball.getX() + dirX - Math.abs(velX));
                ball.setY(ball.getY() + dirY + Math.abs(velY));
            }
            else {
                ball.setX(ball.getX() + dirX - Math.abs(velX));
                ball.setY(ball.getY() + dirY - Math.abs(velY));
            }
        }
    }
}