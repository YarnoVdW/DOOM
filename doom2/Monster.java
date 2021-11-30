package be.kdg.doom2;

public abstract class Monster extends DoomCharacter{
    protected final int STRENGTH = 1;
    protected Player player;

    public Monster(int x, int y, Player player) {
        super(x, y);
        this.player = player;

    }

    public Player getPlayer() {
        return player;
    }

    public String toString() {
        return "M";
    }

    public abstract void attackPlayer();


}
