import common.Warrior;
import gladiators.origins.Egyptian;
import gladiators.origins.Gladiator;
import gladiators.origins.Norman;
import gladiators.origins.Romanian;
import gladiators.specialty.Bestiary;
import gladiators.specialty.Retiary;
import gladiators.specialty.Secutor;

import java.util.Arrays;
import java.util.Scanner;

enum Origin {
    ROMANIAN,
    EGYPTIAN,
    NORMAN
};

enum GladJob {
    SECUTOR,
    RETIARY,
    BESTIARY
};

public class GladiatorFactory {
    public Warrior[] makeGladiators() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Идущие на смерть приветствуют тебя! \nСколько гладиаторов сойдутся на арене. (Максимум 5):");
        int warriorNumber = scanner.nextInt();
        Warrior[] warriors = new Warrior[warriorNumber];
        for (int i = 0; i < warriorNumber; i++) {
            System.out.println((i + 1) + " гладиатор. Как его зовут?");
            String name = scanner.next();
            System.out.println("Сколько ему лет? Помни, молодые здоровее, а зрелые - опытнее. (18 - 40 лет)");
            int age = scanner.nextInt();
            System.out.println("Откуда он родом? 1 - Римлянин, 2 - Египтянин, 3 - Северянин");
            int originIndex = scanner.nextInt();
            System.out.println("Выбери специализацию? 1 - Секутор, 2 - Ретиарий, 3 - Бестиарий");
            int specialityIndex = scanner.nextInt();
            warriors[i] = makeGladiator(name, age, Origin.values()[originIndex - 1], GladJob.values()[specialityIndex - 1]);
        }
        return warriors;
    }


    private Warrior makeGladiator(String name, int age, Origin origin, GladJob gladJob) {
        Gladiator gladiator;
        Warrior warrior;
        switch (origin) {
            case NORMAN:
                gladiator = new Norman(age, name);
                break;
            case EGYPTIAN:
                gladiator = new Egyptian(age, name);
                break;
            case ROMANIAN:
                gladiator = new Romanian(age, name);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + origin);
        }
        switch (gladJob) {
            case SECUTOR:
                warrior = new Secutor(gladiator);
                break;
            case RETIARY:
                warrior = new Retiary(gladiator);
                break;
            case BESTIARY:
                warrior = new Bestiary(gladiator);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gladJob);
        }
        return warrior;
    }
}
