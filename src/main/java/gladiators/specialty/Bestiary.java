package gladiators.specialty;


import common.Balance;
import common.Warrior;
import gladiators.origins.Gladiator;

public class Bestiary extends Speciality {

    public Bestiary(Gladiator source) {
        super(source);
    }

    @Override
    public void special(Warrior enemy) {
        System.out.println(wrapped.name + " исцеляет себя травами на " + Balance.BESTIARY_HEALING + " HP.");
        wrapped.health += Balance.BESTIARY_HEALING;
    }
}
