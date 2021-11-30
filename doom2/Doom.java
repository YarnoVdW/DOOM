package be.kdg.doom2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class Doom {
    private Room room;
    private Monster[] monsters;
    LocalTime timeTwee;
    LocalTime timeEen;
    public Doom() {
        room = new Room();
    }
    public boolean isFinished(){
        return room.isFinished();
    }
    public void start() {
        timeEen = LocalTime.now();
        monsters = room.getMonsters();
        while (!(isFinished())) {
            for (Monster monster : monsters){
                monster.attackPlayer();
            }
            room.update();
            room.draw();
            this.showInfo();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isFinished()){
            System.out.println("you died bitch");
            timeTwee = LocalTime.now();
            Duration tijdsduur = Duration.between(timeEen, timeTwee);
            long seconden = tijdsduur.getSeconds();
            System.out.println("you survived: "+ seconden+ " seconds");
        }
    }
    private void showInfo() {
        System.out.println("health: "+room.getPlayer().getHealth()+ "                 tijd: "+ LocalDate.now());
    }
}

