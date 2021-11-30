package be.kdg.doom2;

import java.util.Random;

import static be.kdg.doom2.Zombie.ZombieStatus.ALIVE;
import static be.kdg.doom2.Zombie.ZombieStatus.DEATH;

public class Zombie extends Monster{


    public enum ZombieStatus {
        ALIVE(), DEATH();

        ZombieStatus() {
        }
    }
    private ZombieStatus status;

    Random random = new Random();

    public Zombie(int x, int y, Player player) {
        super(x, y, player);
    }

    public void move() {
        if(status!= DEATH) {
            int r = random.nextInt(101);
            if(r <= 10) {
                status = ALIVE;
                super.move();
                int b = random.nextInt(101);
                if (b >=30) {
                    status = DEATH;
                }
            }
        }
        if (status == ALIVE) {
            super.move();
        }
    }


    @Override
    public void attackPlayer() {
        if(Math.abs(player.getY() - this.getY()) <= 2 && Math.abs(player.getX() - this.getX()) <= 2) {
            player.attack(STRENGTH);
        }
    }
    public String toString() {
        if (status == ALIVE) {
            return "Z";
        }
        else return "+";
    }

}
