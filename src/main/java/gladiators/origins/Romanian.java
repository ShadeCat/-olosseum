package gladiators.origins;

import common.Balance;
import common.Dice;

public class Romanian extends Gladiator {
    public Romanian(int age, String name) {
        super(age, name);
    }

    @Override
    public void getHit(int hitStrength) {
        if(Dice.roll(Balance.ROMANIAN_IRON_WILL_CHANCE)){
            System.out.println("Благодаря железной воле " + this.name + " игнорирует урон");
        } else {
            super.getHit(hitStrength);
        }
    }
}
