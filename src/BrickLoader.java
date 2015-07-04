public class BrickLoader {
    public static BorderBrick brickArr[];

    public static void Load() {
        brickArr = new BorderBrick[100];

        int k = 0;
        for (int i = 0; i < 26; i++) {
            brickArr[k] = new BorderBrick(i*24, 0);
            k++;
        }
        for(int j=1;j<15;j++) {
            brickArr[k] = new BorderBrick(0, j*24);
            k++;
        }
        for(int j=1;j<15;j++) {
            brickArr[k] = new BorderBrick(600, j*24);
            k++;
        }
    }
}
