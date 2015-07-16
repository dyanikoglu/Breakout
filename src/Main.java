import javax.swing.JFrame;
public class Main extends JFrame {
    public Main() {
        add(new Panel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(630, 520);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}