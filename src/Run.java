import javax.swing.*;
import java.awt.image.BufferedImage;
public class Run extends JFrame {
    public Run() {
        JPanel panel = new MainMenu();
        add(panel);
        setTitle("Breakout");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(230, 90);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        do{repaint();}while(MainMenu.flag);

        remove(panel);

        JPanel panel2 = new GamePanel();
        add(panel2);
        setSize(630, 520);
        setIgnoreRepaint(true);
        setLocationRelativeTo(null);
        setCursor(getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0),
                "null"));

        panel2.requestFocus();
    }
    public static void main(String[] args) {
        new Run();
    }
}