package gladiators.origins;

import common.Balance;
import common.Dice;
import common.Warrior;

public class Norman extends Gladiator {

    public Norman(int age, String name) {
        super(age, name);
    }

    @Override
    public void toHit(Warrior enemy) {
        super.toHit(enemy);
        if (Dice.roll(Balance.NORMAN_CHANCE_OF_BERSERK)) {
            System.out.println(this.name + " впадает в ярость берсерка и наносит дополнительный удар.");
        }
        super.toHit(enemy);
    }
}
