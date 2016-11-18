public class JumpyPaddle extends Paddle {
    public JumpyPaddle() {
        this.setIcon("image/paddle_jumpy.png");
        this.setWidth(128);
        this.setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setIcon("image/paddle_jumpy.png");
        paddle.setWidth(128);
        paddle.setHeight(24);
    }
}
