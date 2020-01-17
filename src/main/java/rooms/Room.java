package rooms;

import behavior.IAttack;
import characters.Being;
import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.melee.Knight;
import treasure.Gold;

import java.util.ArrayList;

public class Room {

    private String name;
    private ArrayList<Enemy> enemies;
    private ArrayList<Being> players;
    private Gold treasure;

    public Room(String name, ArrayList<Enemy> enemies, ArrayList<Being> players, Gold treasure) {
        this.name = name;
        this.enemies = enemies;
        this.players = players;
        this.treasure = treasure;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Being> getPlayers() {
        return players;
    }

    public Gold getTreasure() {
        return treasure;
    }

    //Here would make sense to implement an interface called
//IAttack and cast player into that
//Also we would need to check instanceof every player
//Then instance of enemies too
//    public String fight() {
//        while(player.getCurrentHealth() >=0 && enemy.getCurrentHealth() >=0){
//            if(player.getCurrentHealth() >= 0){
//               if(player instanceof IAttack){
//                   ((IAttack)player).attack(enemy);
//               }
//            }
//            if(enemy.getCurrentHealth() >= 0){
//                ((IAttack)enemy).attack(enemy);
//            }
//        }
//        if(enemy.getCurrentHealth() <= 0){
//            return "The winner is" + player.getName();
//        } else {
//            return "Thw winner is" + enemy.getName();
//        }
//
//    }
}
