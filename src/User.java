public class User {
    static int score = 0;
    static String name = "Doga Can";

    public static void calcScore(int brickType) {
        switch (brickType) {
            case 0: score = score + 5; break;
            case 1: score = score + 5; break;
            case 2: score = score + 10; break;
            case 3: score = score + 5; break;
            case 4: break;
            case 5: score = score + 5; break;
        }
    }
}
