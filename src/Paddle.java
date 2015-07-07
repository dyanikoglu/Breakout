import java.awt.event.KeyEvent;import java.lang.Math;

public class Paddle extends GameObject {
/**
    padType 0 : NormalPaddle
    padType 1 : LargePaddle
    padType 2 : JumpyPaddle
 */
    static int padType;
    int dirX;

    public int getType() {
        return padType;
    }

    public void move() {
        x += dirX;
        if(getType()!=1 && getX()>496)
            x=496;
        else if(getType()==1 && getX()>432)
            x=432;
        if(getX()<0)
            x=0;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dirX = -4;
        if (key == KeyEvent.VK_RIGHT)
            dirX = 4;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dirX = 0;
        if (key == KeyEvent.VK_RIGHT)
            dirX = 0;
    }

    public static void setPaddle(Paddle paddle) {
        if (Math.random() <= 0.5 && paddle.getType()!=2) {
            if (Math.random() <= 0.5)
                paddle.padType = 1;
            else
                paddle.padType = 2;
        }

        else if(paddle.getType()!=1)
            paddle.padType=0;
    }

    public static void changePaddle(Paddle paddle) {
        if(paddle.getType()==0)
            NormalPaddle.set(paddle);
        else if(paddle.getType()==1)
            LargePaddle.set(paddle);
        else if(paddle.getType()==2)
            JumpyPaddle.set(paddle);
    }
}