import java.awt.*;
import java.awt.Graphics;import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;import java.lang.Math;
import javax.swing.*;import javax.swing.JPanel;import javax.swing.Timer;

/**
 * Created by dyanikoglu on 9.06.2015.
 */
public class MovingBall extends JPanel implements ActionListener {
    Timer t = new Timer(5,this);
    double x=257,y=15, velX=1.5, velY=1.5;
    Ellipse2D.Double circle;

    public MovingBall() {
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle = new Ellipse2D.Double(x,y,20,20);
        Graphics2D g2 = (Graphics2D)g;
        g2.fill(circle);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        double a = Math.random();
        if(a<=0.5) {
            if (x < 0 || x > 700) {
                velX = -velX;
            }
            if (y < 0 || y > 700) {
                velY = -velY;
            }
        }
        else {
            if (x < 0) {
                velX = -velX;
                velY = -velY;
            }
            else if(x > 700)
                velX = -velX;

            if (y < 0) {
                velX = -velX;
                velY = -velY;
            }

            else if(y > 700)
                velY = -velY;
        }

        x+=velX;
        y+=velY;
        repaint();
    }
}
