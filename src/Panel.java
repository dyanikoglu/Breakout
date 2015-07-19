import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Timer;

public class Panel extends JPanel{
    static Paddle paddle;
    Ball ball; // non-static
    Timer timer;

    public Panel() {
        setFocusable(true);
        initObjects();
        initTimer();
        addKeyListener(new listener());
    }

    private void initTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new loop(), 1000, 8);
    }

    private void initObjects() {
        paddle = new NormalPaddle(240,470);
        ball = new Ball(200,300);
        BrickLoader.create();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), null);
        g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), null);
        for (int i = 0; i < BrickLoader.brickArr.length; i++) {
            if(!BrickLoader.brickArr[i].getStatus()) {
                g.drawImage(BrickLoader.brickArr[i].getImage(), BrickLoader.brickArr[i].getX(), BrickLoader.brickArr[i].getY(),
                        BrickLoader.brickArr[i].getWidth(), BrickLoader.brickArr[i].getHeight(), this);
            }
        }
    }

    private class listener extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }

    private class loop extends TimerTask {
        public void run() {
            repaint();
            Point.checkCollision(ball);
            paddle.move();
        }
    }
}