public class Ball extends GameObject {
    public Ball(int x,int y) {
        setIcon("image/ball.png");
        setX(x);
        setY(y);
        setWidth(16);
        setHeight(16);
    }

    public void move() {
        Point.checkCollision(this);
        Point.checkVelDir(this);
    }
}
