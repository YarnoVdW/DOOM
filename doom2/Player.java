package be.kdg.doom2;



public class Player extends DoomCharacter {
    public static final double START_HEALTH = 150;
    private double health;


    public Player(int x, int y) {
        super(x, y);
        this.health = START_HEALTH;
    }

    public void attack(double strength) {

        this.health -= strength;

    }
    public boolean isDeath() {

        boolean death;
        if (this.health <= 0) {

            death = true;
        } else {
            death = false;
        }
        return death;
    }

    public double getHealth() {
        return this.health;
    }

    public String toString() {
        return "P";
    }



}
