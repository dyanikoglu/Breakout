public class JumpyPaddle extends Paddle {
    public JumpyPaddle() {
        setImage("image/paddle_jumpy.png");
        setWidth(128);
        setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setImage("image/paddle_jumpy.png");
        paddle.setWidth(128);
        paddle.setHeight(24);
    }
}