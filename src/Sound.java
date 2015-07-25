import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.IOException;
import java.io.InputStream;

public class Sound {
    public static void play(String path) {
        InputStream inputStream = Sound.class.getResourceAsStream(path);
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(inputStream);
        } catch (IOException e) {

        }
        AudioPlayer.player.start(audioStream);
    }
}