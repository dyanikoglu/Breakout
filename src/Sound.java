import java.applet.Applet;
public class Sound {
    public static void play(final String file) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Applet.newAudioClip(getClass().getResource(file)).play();
            }
        }).start();
    }
}
