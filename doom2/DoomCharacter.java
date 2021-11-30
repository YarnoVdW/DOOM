package be.kdg.doom2;

import java.util.Random;

public class DoomCharacter {
    protected int x;
    protected int y;
    private Random random = new Random();
    protected Room room;

    public DoomCharacter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move() {

            int dxWaarde = random.nextInt(3)-1;
            int dyWaarde = random.nextInt(3)-1;
            if (room.isFree(getX() + dxWaarde, getY() + dyWaarde)) {
                this.x += dxWaarde;
                this.y += dyWaarde;
                return;


        }
    }
    public void setRoom(Room room) {
        this.room = room;
    }

}
