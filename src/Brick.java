public class Brick extends GameObject implements ICollidable {
    boolean destroyed;
    int brickType;

    public Brick() {
    }

    public Brick(int x, int y) {
        setX(x);
        setY(y);
        destroyed = false;
    }

    public int getType() {
        return brickType;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = true;
    }

    public void colResponse(Ball ball) {
        for(int i=0;i<110;i++) {
            if (!BrickLoader.brickArr[i].isDestroyed() && BrickLoader.brickArr[i].colDetect(ball)) {

                int ballLeft = (int) ball.getRectangle().getMinX();
                int ballHeight = (int) ball.getRectangle().getHeight();
                int ballWidth = (int) ball.getRectangle().getWidth();
                int ballTop = (int) ball.getRectangle().getMinY();

                java.awt.Point pointRight = new java.awt.Point(ballLeft + ballWidth, ballTop+1);
                java.awt.Point pointLeft = new java.awt.Point(ballLeft, ballTop-1);
                java.awt.Point pointTop = new java.awt.Point(ballLeft, ballTop-1);
                java.awt.Point pointBottom = new java.awt.Point(ballLeft, ballTop + ballHeight+1);

                if (BrickLoader.brickArr[i].getType()!=4) {
                    if (BrickLoader.brickArr[i].getRectangle().contains(pointRight) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirX=-1;
                    }
                    else if (BrickLoader.brickArr[i].getRectangle().contains(pointLeft) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirX=1;
                    }

                    if (BrickLoader.brickArr[i].getRectangle().contains(pointTop) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=1;
                    }
                    else if (BrickLoader.brickArr[i].getRectangle().contains(pointBottom) && BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=-1;
                    }

                    else if(BrickLoader.brickArr[i].getType()!=3) {
                        Point.dirY=-Point.dirY;
                    }

                    if (BrickLoader.brickArr[i].getType() != 4) {
                        BrickLoader.brickArr[i].setDestroyed(true);
                    }

                    break;
                }

                else if(BrickLoader.brickArr[i].getType()==4) {
                    if (BrickLoader.brickArr[i].getRectangle().contains(pointRight) && BrickLoader.brickArr[i].getY()!=0) {
                        double rnd = Math.random();
                        if(rnd<0.5) {
                            Point.dirX = -1;
                            Point.dirY = -1;
                        }
                        else {
                            Point.dirX=-1;
                            Point.dirY=1;
                        }
                    }
                    else if (BrickLoader.brickArr[i].getRectangle().contains(pointLeft) && BrickLoader.brickArr[i].getY()!=0) {
                        double rnd = Math.random();
                        if(rnd<0.5) {
                            Point.dirX = 1;
                            Point.dirY=-1;
                        }
                        else {
                            Point.dirX=1;
                            Point.dirY=1;
                        }
                    }

                    if (BrickLoader.brickArr[i].getRectangle().contains(pointTop) && BrickLoader.brickArr[i].getY()==0) {
                        Point.dirY=1;
                    }
                    else if (BrickLoader.brickArr[i].getRectangle().contains(pointBottom) && BrickLoader.brickArr[i].getY()==0) {
                        Point.dirY=-1;
                    }

                    break;
                }
            }
        }

        if (ball.getY() > 480)
            System.exit(1);


        if(Point.dirX==1) {
            if(Point.dirY==1) {
                ball.x+=Point.dirX+Math.abs(Point.velX);
                ball.y+=Point.dirY+Math.abs(Point.velY);
            }
            else {
                ball.x+=Point.dirX+Math.abs(Point.velX);
                ball.y+=Point.dirY-Math.abs(Point.velY);
            }
        }
        else if(Point.dirX==-1) {
            if(Point.dirY==1) {
                ball.x+=Point.dirX-Math.abs(Point.velX);
                ball.y+=Point.dirY+Math.abs(Point.velY);
            }
            else {
                ball.x+=Point.dirX-Math.abs(Point.velX);
                ball.y+=Point.dirY-Math.abs(Point.velY);
            }
        }
    }

    public boolean colDetect(Ball ball) {
        return (ball.getRectangle().intersects(this.getRectangle()));
    }
}