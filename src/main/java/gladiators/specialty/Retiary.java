package gladiators.specialty;

import common.Warrior;
import gladiators.origins.Gladiator;


public class Retiary extends Speciality  {

    public Retiary(Gladiator source) {
        super(source);
    }

    public void special(Warrior enemy) {
        System.out.println(wrapped.name + " поймал " + enemy.name + " в сеть и нанёс гарантированный урон");
        enemy.getHit(wrapped.strength);
    }
}