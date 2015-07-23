public class NormalPaddle extends Paddle {

    public NormalPaddle(int x, int y) {
        this.setIcon("image/paddle.png");
        this.setX(x);
        this.setY(y);
        this.setWidth(128);
        this.setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setWidth(128);
        paddle.setHeight(24);
        paddle.setIcon("image/paddle.png");
    }
}