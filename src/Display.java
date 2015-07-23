import java.awt.*;

public class Display extends GameObject {
    private String[] uSplitArr;
    private String[] sSplitArr;

    public void read(String str,Graphics g, int x, int y) {
        this.setX(x);
        this.setY(y);
        uSplitArr = str.split("");
        for(int i=0;i<uSplitArr.length;i++) {
            draw(uSplitArr[i], g, i);
        }
    }

    private void draw(String letter,Graphics g,int i) {
        if(letter.equalsIgnoreCase(" ")) {
            return;
        }
        setIcon("image/"+letter+".png");
        g.drawImage(this.getImage(), this.getX() + i*16, this.getY(), 12, 16, null);
    }

    public void read(int score,Graphics g, int x, int y) {
        this.setX(x);
        this.setY(y);
        sSplitArr = Integer.toString(score).split("");
        for(int i=0;i<sSplitArr.length;i++) {
            draw(sSplitArr[i], g, i);
        }
    }
}
