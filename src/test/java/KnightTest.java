import characters.enemy.Orc;
import characters.melee.Knight;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;
    private Weapon weapon1;
    private Weapon weapon2;
    private Orc orc;

    @Before
    public void before(){
        knight = new Knight("Arthur", 5);
        weapon1 = new Weapon("Sword", 3);
        weapon2 = new Weapon("Axe", 2);
        orc = new Orc("Orc", 5, 1, 1);

    }

    @Test
    public void knightNameAndHealth(){
        assertEquals("Arthur", knight.getName());
        assertEquals(5, knight.getCurrentHealth());
        assertEquals(5, knight.getMaxHealth());
    }

    @Test
    public void canAddWeapon(){
        knight.addWeaponToWeapons(weapon1);
        assertEquals(1, knight.getWeapons().size());
    }

    @Test
    public void canChangeWeapon(){
        knight.addWeaponToWeapons(weapon1);
        knight.addWeaponToWeapons(weapon2);
        knight.changeSelectedWeapon(weapon1);
        assertEquals(weapon1, knight.getSelectedWeapon());
    }

    @Test
    public void cannotChangeWeaponDontHaveIt(){
        knight.changeSelectedWeapon(weapon1);
        assertEquals(null, knight.getSelectedWeapon());
    }

    @Test
    public void canAttack(){
        knight.addWeaponToWeapons(weapon1);
        knight.changeSelectedWeapon(weapon1);
        knight.attack(orc);
        assertEquals(2, orc.getCurrentHealth());
    }
}
