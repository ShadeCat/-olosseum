package gladiators.specialty;

import common.Dice;
import common.Warrior;
import gladiators.origins.Gladiator;

public class Secutor extends Speciality {

    public Secutor(Gladiator source) {
        super(source);
    }

    public void special(Warrior enemy) {
        System.out.println(wrapped.name + " метит прямо в сердце чтобы нанести двойной урон.");
        if (Dice.roll(wrapped.accuracy)) {
            enemy.getHit(wrapped.strength * 2);
        }
    }
}
