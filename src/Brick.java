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
        setX(0);
        setY(0);
        status = false;
    }

    public Brick(int x, int y) {
        setX(x);
        setY(y);
        status = false;
    }

    public void setType(int type) {
        this.brickType=type;
    }

    private int getType() {
        return brickType;
    }

    public boolean getStatus() {
        return status;
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
        for(int i=0;i<110;i++) {
            if (!BrickLoader.brickArr[i].getStatus() && BrickLoader.brickArr[i].colDetect(ball)) {

                java.awt.Point pR = new java.awt.Point(ball.getX() + ball.getWidth(), ball.getY()+1);
                java.awt.Point pL = new java.awt.Point(ball.getX(), ball.getY()-1);
                java.awt.Point pT = new java.awt.Point(ball.getX(), ball.getY());
                java.awt.Point pB = new java.awt.Point(ball.getX(), ball.getY() + ball.getHeight());

                if (BrickLoader.brickArr[i].getType()!=4 ) {
                    if (BrickLoader.brickArr[i].getRect().contains(pR) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirX=-1;
                    }

                    else if (BrickLoader.brickArr[i].getRect().contains(pL) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirX=1;
                    }

                    if (BrickLoader.brickArr[i].getRect().contains(pT) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=1;
                    }
                    else if (BrickLoader.brickArr[i].getRect().contains(pB) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=-1;
                    }

                    else if(BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=-Point.dirY;
                    }

                    if (BrickLoader.brickArr[i].getType() != 4) {
                        BrickLoader.brickArr[i].setStatus(true);
                    }

                    break;
                }

                else if(BrickLoader.brickArr[i].getType()==4) {
                    if (BrickLoader.brickArr[i].getRect().contains(pR) && BrickLoader.brickArr[i].getY()!=0) {
                        if(Math.random()>=0.5) {
                            Point.dirX = -1;
                            Point.dirY = -1;
                        }
                        else {
                            Point.dirX=-1;
                            Point.dirY=1;
                        }
                    }

                    else if (BrickLoader.brickArr[i].getRect().contains(pL) && BrickLoader.brickArr[i].getY()!=0) {
                        if(Math.random()>=0.5) {
                            Point.dirX = 1;
                            Point.dirY=-1;
                        }
                        else {
                            Point.dirX=1;
                            Point.dirY=1;
                        }
                    }

                    if (BrickLoader.brickArr[i].getRect().contains(pT) && BrickLoader.brickArr[i].getY()==0) {
                        Point.dirY=1;
                        if(Math.random()<0.5) {
                            Point.dirX = 1;
                        }
                        else {
                            Point.dirX=-1;
                        }

                    }
                    else if (BrickLoader.brickArr[i].getRect().contains(pB) && BrickLoader.brickArr[i].getY()==0) {
                        Point.dirY=-1;
                        if(Math.random()<0.5) {
                            Point.dirX = 1;
                        }
                        else {
                            Point.dirX=-1;
                        }
                    }

                    break;
                }
            }
        }

        if (ball.getY() > 480) {
            Panel.isGameOver = true;
        }

        if(Point.dirX==1) {
            if(Point.dirY==1) {
                ball.setX(ball.getX() + Point.dirX + Math.abs(Point.velX));
                ball.setY(ball.getY() + Point.dirY + Math.abs(Point.velY));
            }
            else {
                ball.setX(ball.getX() + Point.dirX + Math.abs(Point.velX));
                ball.setY(ball.getY() + Point.dirY - Math.abs(Point.velY));
            }
        }
        else if(Point.dirX==-1) {
            if(Point.dirY==1) {
                ball.setX(ball.getX() + Point.dirX - Math.abs(Point.velX));
                ball.setY(ball.getY() + Point.dirY + Math.abs(Point.velY));
            }
            else {
                ball.setX(ball.getX()+Point.dirX - Math.abs(Point.velX));
                ball.setY(ball.getY() + Point.dirY - Math.abs(Point.velY));
            }
        }
    }

    public boolean colDetect(Ball ball) {
        return (ball.getRect().intersects(this.getRect()));
    }
}