package com.dyanikoglu.retrobreakout.GameObject;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameObject {
    private int x,y,width,height;
    private Image img;
    protected static final ClassLoader loader = GameObject.class.getClassLoader();

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

    public void setIcon(URL imageLoc) {
        ImageIcon imgIcon = new ImageIcon(imageLoc);
        img = imgIcon.getImage();
    }

    public Rectangle getRect() {
        return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
    }
}