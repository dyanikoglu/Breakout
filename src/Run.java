import javax.swing.*;
import java.awt.image.BufferedImage;
public class Run extends JFrame {
    public Run() {
        JPanel mainmenu = new MainMenu();
        add(mainmenu);

        setTitle("Breakout");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(230, 90);
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

        Sound.music();
    }
    public static void main(String[] args) {
        new Run();
    }
}