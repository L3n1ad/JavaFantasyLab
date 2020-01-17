import characters.Being;
import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.enemy.Troll;
import characters.melee.Knight;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import treasure.Gold;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomTest {

    private Room room;
    private Orc orc;
    private Troll troll;
    private Knight knight;
    private Weapon weapon;
    private Gold gold;
    private ArrayList<Being> players;
    private ArrayList<Enemy> enemies;

    @Before
    public void before(){
        knight = new Knight("Arthur", 5);
        weapon = new Weapon("Sword", 3);
        knight.addWeaponToWeapons(weapon);
        players = new ArrayList<Being>();
        players.add(knight);
        orc = new Orc("Orc", 5, 2, 1);
        troll = new Troll("Troll", 5, 1,1);
        gold = new Gold(10);
        enemies = new ArrayList<Enemy>();
        enemies.add(orc);
        enemies.add(troll);
        room = new Room("Level 1", enemies, players, gold);
    }

    @Test
    public void hasName(){
        assertEquals("Level 1", room.getName());
    }

    @Test
    public void hasEnemies(){
        assertEquals(2, room.getEnemies().size());
    }

    @Test
    public void hasPlayers(){
        assertEquals(1, room.getPlayers().size());
    }

    @Test
    public void hasTreasure(){
        assertEquals(gold, room.getTreasure());
    }

//    @Test
//    public void canFight(){
//        room.fight();
//        assertEquals(10, knight.getWallet());
//        assertTrue(orc.getCurrentHealth() <= 0);
//        assertTrue(knight.getCurrentHealth() >= 0);
//    }
}
