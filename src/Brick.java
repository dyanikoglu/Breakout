import java.util.Random;

public class Brick extends GameObject implements ICollidable {

/**
    * brickType 0 : normalBrick
    * brickType 1 : stoneBrick
    * brickType 2 : gemBrick
    * brickType 3 : glassBrick
    * brickType 4 : borderBrick
    * brickType 5 : stoneBrick(broken)
*/
    private int brickType;
    private boolean status;

    public Brick() {
        this.setX(0);
        this.setY(0);
        this.status = false;
    }

    public Brick(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.status = false;
    }

    public void setType(int type) {
        this.brickType=type;
    }

    public int getType() {
        return this.brickType;
    }

    public boolean getStatus() {
        return this.status;
    }

    private void setStatus(boolean status) {
        if(this.getType() == 1) {
            this.setIcon("image/brick_stone_2.png");
            this.setType(5);
        }
        else {
            this.status = status;
        }
    }

    public void colResponse(Ball ball) {
        User.calcScore(this.getType());

        java.awt.Point pR = new java.awt.Point(ball.getX() + ball.getWidth() + 1, ball.getY());
        java.awt.Point pL = new java.awt.Point(ball.getX() - 1, ball.getY());
        java.awt.Point pT = new java.awt.Point(ball.getX() + ball.getHeight() / 2, ball.getY() - 1);
        java.awt.Point pB = new java.awt.Point(ball.getX() + ball.getHeight() / 2, ball.getY() + ball.getHeight() + 1);

        if (this.getType() != 4) {
            if (this.getRect().contains(pR) && this.getType() != 3) {
                Point.dirX = -1;
            }
            else if (this.getRect().contains(pL) && this.getType() != 3) {
                Point.dirX = 1;
            }

            if (this.getRect().contains(pT) && this.getType() != 3) {
                Point.dirY = 1;
            }
            else if (this.getRect().contains(pB) && this.getType() != 3) {
                Point.dirY = -1;
            }

            else if (this.getType() != 3) { // fix for collision of corner of ball
                Point.dirY = -Point.dirY;
            }

            if (this.getType() != 4) {
                this.setStatus(true);
            }
        }

        else if (this.getType() == 4) {
            if (this.getRect().contains(pR) && this.getY() != 0) {
                if (new Random().nextInt(2) == 1) {
                    Point.dirX = -1;
                    Point.dirY = -1;
                }
                else {
                    Point.dirX = -1;
                    Point.dirY = 1;
                }
            }

            else if (this.getRect().contains(pL) && this.getY() != 0) {
                if (new Random().nextInt(2) == 1) {
                    Point.dirX = 1;
                    Point.dirY = -1;
                }
                else {
                    Point.dirX = 1;
                    Point.dirY = 1;
                }
            }

            if (this.getRect().contains(pT) && this.getY() == 0) {
                Point.dirY = 1;
                if (new Random().nextInt(2) == 1) {
                    Point.dirX = 1;
                }
                else {
                    Point.dirX = -1;
                }

            } else if (this.getRect().contains(pB) && this.getY() == 0) {
                Point.dirY = -1;
                if (new Random().nextInt(2) == 1) {
                    Point.dirX = 1;
                }
                else {
                    Point.dirX = -1;
                }
            }
        }
    }


    public boolean colDetect(Ball ball) {
        return (ball.getRect().intersects(this.getRect()));
    }
}