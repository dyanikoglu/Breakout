import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BrickLoader {
    public static BorderBrick brickArr[];

    public static void Load() {

}

    public String read() {
        File f = new File("C:\\Users\\dyani\\IdeaProjects\\fileio\\output.txt");
        try {
            Scanner scan = new Scanner(f);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
