package gladiators.specialty;

import common.Balance;
import common.Dice;
import common.SpecialActions;
import common.Warrior;
import gladiators.origins.Gladiator;


public abstract class Speciality extends Warrior implements SpecialActions {
    protected final Gladiator wrapped;

    public Speciality(Gladiator source) {
        this.wrapped = source;
        this.health = this.wrapped.health;
        this.name = this.wrapped.name;
    }


    public void makeTurn(Warrior enemy) {
        if (Dice.roll(Balance.SPECIAL_ATTACK_CHANCE)) {
            special(enemy);
        } else {
            wrapped.toHit(enemy);
        }
    }

    public abstract void special(Warrior enemy);
}
