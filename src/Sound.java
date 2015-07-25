import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Sound {
    public static Clip clip = null;

    public static void play(String path) {
        InputStream inputStream = Sound.class.getResourceAsStream(path);
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
    }

    public static void music() {
        AudioInputStream inputStream = null;
        try {
            inputStream = AudioSystem.getAudioInputStream(new File(BrickLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"sound\\background.wav"));
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