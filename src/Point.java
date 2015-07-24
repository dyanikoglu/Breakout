public class Point  {
    static int dirX=1, dirY=1, velX=0, velY=0;
    public void control(Ball ball) {
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