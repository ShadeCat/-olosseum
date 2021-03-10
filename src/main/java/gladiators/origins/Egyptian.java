package gladiators.origins;

import common.Balance;
import common.Dice;

public class Egyptian extends Gladiator {

    public Egyptian(int age, String name) {
        super(age, name);

    }

    @Override
    public void getHit(int hitStrength) {
        super.getHit(hitStrength);
        if (this.health < 1) {
            if (Dice.roll(Balance.EGYPTIAN_RESURRECT_CHANCE)) {
                System.out.println(this.name + " восстал и продолжил сражение в загробной жизни.");
                this.health += Balance.EGYPTIAN_RESURRECT_HP;
            }
        }
    }
}
