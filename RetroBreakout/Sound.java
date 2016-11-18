import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    public static Clip clip = null;

    public static void play(String filename)
    {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File( (BrickLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath() + filename).replaceAll("%20"," ") )));
            clip.start();
        }
        catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public static void music() {
        AudioInputStream inputStream = null;
        try {
            inputStream = AudioSystem.getAudioInputStream(new File( (BrickLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"sound\\background.wav").replaceAll("%20"," ") ));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            clip = AudioSystem.getClip();
            clip.open(inputStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}