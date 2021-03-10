package common;

public abstract class Warrior {
    public String name;
    public int health;

    abstract public void makeTurn(Warrior target);

    public void getHit(int hitStrength) {
        this.health -= hitStrength;
        System.out.println(this.name + " получил " + hitStrength + " HP урона. Осталось " + this.health + " HP.");
        if (this.health < 1) {
            System.out.println("Гладиатор " + this.name + " пал.");
        }
    }
}
