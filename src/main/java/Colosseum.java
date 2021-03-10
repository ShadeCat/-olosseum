import common.Warrior;

public class Colosseum {
    public static void main(String[] args) {
        GladiatorFactory gladiatorFactory = new GladiatorFactory();
        Warrior[] gladiators = gladiatorFactory.makeGladiators();
        Battle battle = new Battle(gladiators);
        battle.run();
        battle.graceWinner();
    }
}
