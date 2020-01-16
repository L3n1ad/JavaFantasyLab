import characters.enemy.Enemy;
import characters.enemy.Orc;
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
    private Knight knight;
    private Weapon weapon;
    private Gold gold;

    @Before
    public void before(){
        knight = new Knight("Arthur", 5);
        weapon = new Weapon("Sword", 3);
        knight.addWeaponToWeapons(weapon);
        orc = new Orc("Orc", 5, 2, 1);
        gold = new Gold(10);
        room = new Room("Level 1", orc, knight, gold);
    }

    @Test
    public void roomHasEverything(){
        assertEquals("Level 1", room.getName());
        assertEquals(orc, room.getEnemy());
        assertEquals(knight, room.getPlayer());
        assertEquals(gold, room.getTreasure());
    }

    @Test
    public void canFight(){
        room.fight();
        assertEquals(10, knight.getWallet());
        assertTrue(orc.getCurrentHealth() <= 0);
        assertTrue(knight.getCurrentHealth() >= 0);
    }
}
