public class Point  {
    static int dirX=1,dirY=1;

    public static void move(Ball ball,Paddle paddle) {
        double a = Math.random();
        if (dirY > 0 && ball.getY() > 380 && ball.getX() < paddle.getX() + paddle.getWidth() && ball.getX() > paddle.getX()) {
            dirY = -dirY;
            Sound.play("sound/boing.wav");
            if (paddle.getType() == 2) {
                Sound.play("sound/laser.wav");
                dirY--;
                if(dirX<0)
                    dirX--;
                else
                    dirX++;
            }
            paddle.setPaddle(paddle);
            paddle.changePaddle(paddle);
        }

        if (a <= 0.5) {
            if(ball.getY() < 388) {
                if (ball.getX() < 24 || ball.getX() > 580) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                }
                if (ball.getY() < 24) {
                    Sound.play("sound/boing.wav");
                    dirY = -dirY;
                }
            }
            else {
                if (ball.getX() < 0 || ball.getX() > 604) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                }
                if (ball.getY() < 0) {
                    Sound.play("sound/boing.wav");
                    dirY = -dirY;
                }
            }
        }

        else {
            if(ball.getY() < 388) {
                if (ball.getX() < 24) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                } else if (ball.getX() > 580) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                }
                if (ball.getY() < 24) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                }
            }
            else {
                if (ball.getX() < 0) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                } else if (ball.getX() > 604) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                }
                if (ball.getY() < 0) {
                    Sound.play("sound/boing.wav");
                    dirX = -dirX;
                    dirY = -dirY;
                }
            }
        }

        if (ball.getY() > 400)
            Panel.ball = new Ball(200,300);

        ball.x += dirX;
        ball.y += dirY;
    }
}