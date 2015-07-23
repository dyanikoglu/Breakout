import javax.swing.*;
import java.awt.*;

public class Display extends GameObject {
    private static Image img;
    private static String[] uSplitArr;
    private static String[] sSplitArr;

    public static void read(String str,Graphics g, int x,int y) {
        uSplitArr = str.split("");
        for(int i=0;i<uSplitArr.length;i++) {
            draw(uSplitArr[i], g, i, x,y);
        }
    }

    private static void draw(String letter,Graphics g,int i,int x,int y) {
        if(letter.equalsIgnoreCase(" ")) {
            return;
        }
        ImageIcon imgIcon = new ImageIcon(Display.class.getResource("image/"+letter+".png"));
        img = imgIcon.getImage();
        g.drawImage(img,x+i*16,y,12,16,null); //40
    }

    public static void read(int score,Graphics g, int x, int y) {
        sSplitArr = Integer.toString(score).split("");
        for(int i=0;i<sSplitArr.length;i++) {
            draw(sSplitArr[i], g, i,x,y);
        }
    }
}
