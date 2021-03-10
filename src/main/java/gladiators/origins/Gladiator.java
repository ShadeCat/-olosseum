package gladiators.origins;

import common.Balance;
import common.Dice;
import common.Warrior;
import common.BasicActions;

public abstract class Gladiator extends Warrior implements BasicActions {

    public final int accuracy;
    public final int strength;
    public int age;

    Gladiator(int age, String name) {
        this.age = ageValidate(age);
        this.name = nameValidate(name);
        this.accuracy = (int) (30 + (age - Balance.MIN_AGE) * Balance.ACCURACY_AGE_COEFFICIENT);
        this.strength = (int) (30 - (age - Balance.MIN_AGE) * Balance.STRENGTH_AGE_COEFFICIENT);
        this.health = 100;

    }

    @Override
    public void makeTurn(Warrior target) {
        this.toHit(target);
    }

    public void toHit(Warrior enemy) {
        System.out.println(this.name + " атакует " + enemy.name + ".");
        if (Dice.roll(this.accuracy)) {
            enemy.getHit(this.strength);
        } else {
            System.out.println(enemy.name + " отразил удар.");
        }
    }


    private static int ageValidate(int age) {
        if (age < Balance.MIN_AGE || age > Balance.MAX_AGE) {
            throw new IllegalArgumentException(
                    "На арену допускаются только гадиаторы с " + Balance.MIN_AGE + " до " + Balance.MAX_AGE + " лет");
        }
        return age;
    }

    private static String nameValidate(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(
                    "Имя гладиатора не может быть пустым");
        }
        return name;
    }
}

