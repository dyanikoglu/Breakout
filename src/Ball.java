public class Ball extends GameObject {
    public Ball(int x,int y) {
        setIcon("image/ball.png");
        setX(x);
        setY(y);
        setWidth(16);
        setHeight(16);
    }

    public void col() {
        for(int i=0;i<110;i++) {
            if (!BrickLoader.brickArr[i].getStatus() && BrickLoader.brickArr[i].colDetect(this)) {
                BrickLoader.brickArr[i].colResponse(this);
                break;
            }
        }
    }
}
