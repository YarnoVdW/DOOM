package be.kdg.doom2;

public class SimpleMonster extends Monster{
    public SimpleMonster(int x, int y, Player player) {
        super(x, y, player);
    }
    @Override
    public void attackPlayer() {
        if(Math.abs(player.getY() - this.getY()) <= 2 && Math.abs(player.getX() - this.getX()) <= 2) {
            player.attack(STRENGTH);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
