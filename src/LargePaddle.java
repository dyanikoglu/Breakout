public class LargePaddle extends Paddle {

    public LargePaddle() {
        setImage("image/paddle_long.png");
        setWidth(192);
        setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setImage("image/paddle_long.png");
        paddle.setWidth(192);
        paddle.setHeight(24);
    }
}