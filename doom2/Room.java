package be.kdg.doom2;

import java.sql.Time;
import java.util.Random;

public class Room {
    public static final int WIDTH = 30;
    public static final int HEIGTH = 30;

    private be.kdg.doom2.Player player;
    private char[][] floorPlan;
    private Monster[] monsters = new Monster[15];
    Random random = new Random();


    public Room() {
        this.player = new be.kdg.doom2.Player(WIDTH/2, HEIGTH/2);
        floorPlan = new char[WIDTH][HEIGTH];
        player.setRoom(this);
        createFloorplan();
        makeMonsters();
    }
    public void makeMonsters() {
        for (int i = 0; i < 3; i++) {
            monsters[i] = new Follower(random.nextInt(29), random.nextInt(29), player);
            monsters[i].setRoom(this);
        }
        for (int i = 3; i < 8; i++) {
            monsters[i] = new SimpleMonster(random.nextInt(29), random.nextInt(29),player );
            monsters[i].setRoom(this);
        }
        for (int i =8; i< 11; i++) {
            monsters[i] = new TimeBomb(random.nextInt(29), random.nextInt(29),player );
            monsters[i].setRoom(this);
        }
        for (int i =11; i< monsters.length; i++) {
            monsters[i] = new Zombie(random.nextInt(29),random.nextInt(29), player );
            monsters[i].setRoom(this);
        }



    }

    private void createFloorplan() {
        floorPlan = new char[HEIGTH][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            floorPlan[0][i] = '-';
            floorPlan[HEIGTH - 1][i] = '-';

        }
        for (int i = 0; i < HEIGTH; i++) {
            floorPlan[i][0] = '|';
            floorPlan[i][WIDTH - 1] = '|';
        }
        for (int i = 1; i < HEIGTH - 1; i++) {
            for (int j = 1; j < WIDTH - 1; j++) {
                floorPlan[i][j] = ' ';
            }
        }


    }

    public void draw() {
        for (char[] row : floorPlan) {
            for (char kar : row) {
                System.out.print(kar + " ");
            }
            System.out.println();
        }
    }

    public boolean isFree(int x, int y) {

        if (x < floorPlan.length && x >= 0)
            if (y < floorPlan[x].length && y >= 0)
                return floorPlan[x][y] == ' ';
        return false;
    }

    public boolean isFinished() {
        return player.isDeath();

    }


    public void update() {
        floorPlan[player.getX()][player.getY()] = ' ';

        player.move();
        floorPlan[player.getX()][player.getY()] = player.toString().charAt(0);
        for (Monster monster : monsters) {

            floorPlan[monster.getX()][monster.getY()]= ' ';
            monster.move();

            floorPlan[monster.getX()][monster.getY()] = monster.toString().charAt(0);
        }



    }

    public be.kdg.doom2.Player getPlayer() {
        return player;
    }


    public Monster[] getMonsters() {
        return monsters;
    }
}

