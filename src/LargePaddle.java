public class LargePaddle extends Paddle {

    public LargePaddle() {
        this.setIcon("image/paddle_long.png");
        this.setWidth(192);
        this.setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setIcon("image/paddle_long.png");
        paddle.setWidth(192);
        paddle.setHeight(24);
    }
}