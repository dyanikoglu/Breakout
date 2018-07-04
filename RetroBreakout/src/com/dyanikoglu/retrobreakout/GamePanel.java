package com.dyanikoglu.retrobreakout;

import com.dyanikoglu.retrobreakout.GameObject.Ball;
import com.dyanikoglu.retrobreakout.GameObject.GameObject;
import com.dyanikoglu.retrobreakout.GameObject.Paddle.NormalPaddle;
import com.dyanikoglu.retrobreakout.GameObject.Paddle.Paddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.*;
import java.util.Timer;
public class GamePanel extends JPanel{
    protected static Paddle paddle;
    private Point velocity;
    private Ball ball;
    private Timer timer;
    private Display gameInfo;
    private String wonMsg = "Congratulations", lostMsg = "Game Over";
    private final GameObject background = new GameObject();
    private final ClassLoader loader = GamePanel.class.getClassLoader();

    // Resource URLs
    private URL BricksURL;
    private URL ImageURL;
    private URL SoundURL;

    /**
     * endGame 0 : Game Continues
     * endGame 1 : Game Lost
     * endGame 2 : Game Won
     */
    public static int endGame = 0;

    public GamePanel() {
        setFocusable(true);
        initGame();
        initTimer();
        addKeyListener(new Listener());
    }

    private void initTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Loop(), 1000, 8);
    }


    private void initGame() {
        velocity = new Point();
        gameInfo = new Display();
        paddle = new NormalPaddle(240,470);
        ball = new Ball(200,300);
        BrickLoader.createBricks(loader.getResource("txt/bricks.txt"));
        background.setIcon(loader.getResource("image/background.jpg"));

        // Play background music in seperate thread
        new Thread(
                () -> {
                    try {
                        Sound.BackgroundMusic(loader.getResource("sound/background.wav"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
    }

    private void checkEndGame() {
        for(int i=0;i<110;i++) {
            if (!BrickLoader.brickArr[i].getStatus() && BrickLoader.brickArr[i].getType()!=4) {
                endGame=0;
                break;
            }
            endGame=2;
        }

        if (ball.getY() > 480) {
            endGame = 1;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background.getImage(),0,0,630,520,null);
        g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), null);
        g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), null);
        for (int i = 0; i < BrickLoader.brickArr.length; i++) {
            if(!BrickLoader.brickArr[i].getStatus()) {
                g.drawImage(BrickLoader.brickArr[i].getImage(), BrickLoader.brickArr[i].getX(), BrickLoader.brickArr[i].getY(),
                        BrickLoader.brickArr[i].getWidth(), BrickLoader.brickArr[i].getHeight(), this);
            }
        }

        if(endGame == 0) {
            gameInfo.read(User.name, g, 40, 430);
            gameInfo.read(User.score, g, 543, 430);
        }

        else if(endGame == 1) {
            Sound.clip.stop();
            Sound.Play(loader.getResource("sound/gameover.wav"));
            g.setColor(Color.black);
            g.fillRect(0,0,getWidth(), getHeight());
            gameInfo.read(lostMsg, g, 250, 250);
            gameInfo.read("Your Score is " + User.score,g,197,280);
        }

        else if(endGame == 2) {
            Sound.clip.stop();
            Sound.Play(loader.getResource("sound/gamewn.wav"));
            g.setColor(Color.yellow);
            g.fillRect(0, 0, getWidth(), getHeight());
            gameInfo.read(wonMsg, g, 190, 250);
            gameInfo.read("Your Score is " + User.score,g,176,280);
        }
    }

    private class Listener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }

    private class Loop extends TimerTask {
        public void run() {
            if(endGame == 0) {
                repaint();
                ball.movement();
                paddle.move(ball);
                velocity.control(ball);
                checkEndGame();
            }
            else {
                setBackground(Color.black);
                repaint();
                timer.cancel();
            }
        }
    }
}