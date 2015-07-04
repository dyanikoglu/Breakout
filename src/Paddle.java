import java.awt.event.KeyEvent;import java.lang.Math;

public class Paddle extends GameObject {
/**
    padType 0 : NormalPaddle
    padType 1 : LargePaddle
    padType 2 : JumpyPaddle
 */
    static int padType;
    int dirX;

    public void move() {
        x += dirX;
        if(padType!=1 && getX()>490)
            x=490;
        else if(padType==1 && getX()>426)
            x=426;
        if(getX()<0) {
            x=0;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dirX = -4;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dirX = 4;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dirX = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dirX = 0;
        }
    }

    public static void setPaddle(Paddle paddle) {
        if (Math.random() <= 0.5 && paddle.padType!=2) {
            if (Math.random() <= 0.5) {
                paddle.padType = 1;
            }
            else {
                Sound.play("sound/change.wav");
                paddle.padType = 2;
            }
        }
        else if(paddle.padType!=1)
            paddle.padType=0;
    }

    public static void changePaddle(Paddle paddle) {
        if(paddle.padType==0)
            NormalPaddle.set(paddle);
        else if(paddle.padType==1)
            LargePaddle.set(paddle);
        else if(paddle.padType==2)
            JumpyPaddle.set(paddle);
    }
}