package be.kdg.doom2;

public class Follower extends SimpleMonster{
    public Follower(int x, int y, Player player) {
        super(x, y, player);
    }

    @Override
    public void move() {
        if (this.getX() < player.x) {
            if (room.isFree(getX(), getY())) {
                this.x++;
            }
        }
        else if (this.getX() > player.x) {
            if (room.isFree(getX(), getY())) {
                this.x--;
            }
        }
        else if (this.getY() < player.y) {
            if (room.isFree(getX(), getY())) {
                this.y++;
            }
        }
        else if (this.getY() > player.y) {
            if (room.isFree(getX(), getY())) {
                this.y--;
            }
        }
    }

    @Override
    public String toString() {
        return "F";
    }
}
