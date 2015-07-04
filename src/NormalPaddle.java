public class NormalPaddle extends Paddle {

    public NormalPaddle(int x, int y) {
        setImage("image/paddle.png");
        setX(x);
        setY(y);
        setWidth(128);
        setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setWidth(128);
        paddle.setHeight(24);
        paddle.setImage("image/paddle.png");
    }
}