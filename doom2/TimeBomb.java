package be.kdg.doom2;

import java.util.Random;

public class TimeBomb extends Monster{
    public TimeBomb(int x, int y, Player player) {
        super(x, y, player);
    }
    Random random = new Random();

    private final double BOMB_STRENGTH =1;
    private int startTime = random.nextInt(10)+5;
    private int timeLeft;
    @Override
    public void move() {
        this.startTime--;

    }
    public void attackPlayer() {
        if (this.startTime==0){
            if (player.getX() - this.x <=3 || player.getY() - this.y <=3) {
                player.attack(BOMB_STRENGTH);
                this.startTime = random.nextInt(10)+5;
            }

        }
    }
    public String toString() {
        return "B";
    }



}

