import java.awt.event.KeyEvent;import java.lang.Math;

public class Paddle extends GameObject implements ICollidable {
    /**
     * padType 0 : NormalPaddle
     * padType 1 : LargePaddle
     * padType 2 : JumpyPaddle
     */

    static int padType;
    int keyboardDirX;

    public int getType() {
        return padType;
    }

    public void move() {
        x += keyboardDirX;
        if (getType() != 1 && getX() > 496)
            x = 496;
        else if (getType() == 1 && getX() > 432)
            x = 432;
        if (getX() < 0)
            x = 0;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            keyboardDirX = -4;
        if (key == KeyEvent.VK_RIGHT)
            keyboardDirX = 4;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            keyboardDirX = 0;
        if (key == KeyEvent.VK_RIGHT)
            keyboardDirX = 0;
    }

    public static void setPaddle(Paddle paddle) {
        if (Math.random() <= 0.1 && paddle.getType() != 2) {
            if (Math.random() <= 0.5)
                paddle.padType = 1;
            else
                paddle.padType = 2;
        } else if (paddle.getType() != 1)
            paddle.padType = 0;
    }

    public static void changePaddle(Paddle paddle) {
        if (paddle.getType() == 0)
            NormalPaddle.set(paddle);
        else if (paddle.getType() == 1)
            LargePaddle.set(paddle);
        else if (paddle.getType() == 2)
            JumpyPaddle.set(paddle);
    }

    public boolean colDetect(Ball ball) {
        return (Point.dirY > 0 && ball.getY() > 455 && ball.getX() < getX() + getWidth() && ball.getX() > getX());
    }

    public void colResponse(Ball ball) {
        if (colDetect(ball)) {
            Point.dirY = -Point.dirY;
            if (getType() == 2) {
                Point.velY++;
                Point.velX++;
            }
            setPaddle(this);
            changePaddle(this);
        }
    }
}