package common;

import java.util.Random;

public class Dice {
    public static boolean roll(int chance){
        Random random = new Random();
        int diceRoll = random.nextInt(100);
        return diceRoll < chance;
    }
}
