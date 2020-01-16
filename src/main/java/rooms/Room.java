package rooms;

import characters.Being;
import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.melee.Knight;
import treasure.Gold;

public class Room {

    private String name;
    private Enemy enemy;
    private Being player;
    private Gold treasure;

    public Room(String name, Enemy enemy, Being player,Gold treasure) {
        this.name = name;
        this.treasure = treasure;
        setPlayer(player);
        setEnemy(enemy);
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Being getPlayer() {
        return player;
    }

    public Gold getTreasure() {
        return treasure;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setPlayer(Being player) {
        this.player = player;
    }

//Here would make sense to implement an interface called
//IAttack and cast player into that
//Also we would need to check instanceof every player
//Then instance of enemies too
    public String fight() {
        while(player.getCurrentHealth() >=0 && enemy.getCurrentHealth() >=0){
            if(player.getCurrentHealth() >= 0){
               if(player instanceof IAttack){
                   ((IAttack)player).attack(enemy);
               }
            }
        }

    }
}
