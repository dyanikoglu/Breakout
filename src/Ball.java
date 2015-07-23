public class Ball extends GameObject {
    public Ball(int x,int y) {
        this.setIcon("image/ball.png");
        this.setX(x);
        this.setY(y);
        this.setWidth(16);
        this.setHeight(16);
    }

    public void checkCol() {
        for(int i=0;i<110;i++) {
            if (!BrickLoader.brickArr[i].getStatus() && BrickLoader.brickArr[i].colDetect(this)) {
                BrickLoader.brickArr[i].colResponse(this);
                break;
            }
        }
    }
}
