package com.dyanikoglu.retrobreakout.GameObject.Paddle;

public class LargePaddle extends Paddle {
    public LargePaddle() {
        this.setIcon(loader.getResource("image/paddle_long.png"));
        this.setWidth(192);
        this.setHeight(24);
    }

    public static void set(Paddle paddle) {
        paddle.setIcon(loader.getResource("image/paddle_long.png"));
        paddle.setWidth(192);
        paddle.setHeight(24);
    }
}