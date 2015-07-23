import javax.swing.JFrame;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    public Main() {
        add(new Panel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(630, 520);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setCursor(getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0,0),
                "null"));
    }
    public static void main(String[] args) {
        new Main();
    }
}