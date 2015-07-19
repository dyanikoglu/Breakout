import javax.swing.*;
import java.awt.*;

public class GameObject {
    int x,y,width,height;
    Image img;

    public void setIcon(String imageLoc) {
        ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(imageLoc));
        img = imgIcon.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    public void setHeight(int height) {
        this.height=height;
    }

    public void setWidth(int width) {
        this.width=width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return img;
    }

    public Rectangle getRect() {
        return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
    }
}