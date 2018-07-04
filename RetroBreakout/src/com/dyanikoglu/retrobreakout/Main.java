package com.dyanikoglu.retrobreakout;

import javax.swing.*;
import java.awt.image.BufferedImage;
public class Main extends JFrame {
    public Main() {
        JPanel mainmenu = new MainMenu();
        add(mainmenu);

        setTitle("Retro Breakout");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 90);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        do{repaint();}while(MainMenu.flag);

        remove(mainmenu);

        JPanel gamepanel = new GamePanel();
        add(gamepanel);

        setSize(630, 520);
        setIgnoreRepaint(true);
        setLocationRelativeTo(null);
        setCursor(getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0), "null"));
        gamepanel.requestFocus();
    }
    public static void main(String[] args) {
        new Main();
    }
}