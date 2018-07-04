package com.dyanikoglu.retrobreakout;

public class User {
    static int score = 0;
    final static String name = MainMenu.nameTextField.getText();

    public static void calcScore(int brickType) {
        switch (brickType) {
            case 0: score += 5; break;
            case 1: break;
            case 2: score += 10; break;
            case 3: score += 5; break;
            case 4: break;
            case 5: score += 5; break;
        }
    }
}
