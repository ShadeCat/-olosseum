import common.Warrior;

import java.util.Random;

public class Battle {
    private final Warrior[] warriors;

    Battle(Warrior[] warriors) {
        this.warriors = warriors;
    }

    public void run() {
        boolean continueBattle = true;
        while (continueBattle) {
            for (int currentWarriorIndex = 0; currentWarriorIndex < warriors.length; currentWarriorIndex++) {
                Warrior activeWarrior = warriors[currentWarriorIndex];
                Warrior target = warriors[selectTarget(currentWarriorIndex, warriors)];
                activeWarrior.makeTurn(target);
                if (isBattleOver(warriors)) {
                    continueBattle = false;
                    break;
                }

            }

        }
    }

    private int selectTarget(int currentWarriorIndex, Warrior[] warriors) {
        boolean isTargetSelected = false;
        Random random = new Random();
        int targetIndex = random.nextInt(warriors.length);
        while (!isTargetSelected) {
            targetIndex = random.nextInt(warriors.length);
            if (targetIndex != currentWarriorIndex && warriors[targetIndex].health > 0) {
                isTargetSelected = true;
            }
        }
        return targetIndex;

    }

    private boolean isBattleOver(Warrior[] warriors) {
        boolean isOver = true;
        int standingGladiators = 0;
        for (Warrior warrior : warriors) {
            if (warrior.health > 0) {
                standingGladiators += 1;
            }
        }
        if (standingGladiators > 1) {
            isOver = false;
        }
        return isOver;
    }

    public void graceWinner() {
        for (Warrior warrior : warriors) {
            if (warrior.health > 0) {
                System.out.println("Гладиатор " + warrior.name + " вышел победителем!");
            }
        }
    }
}
