import characters.enemy.Orc;
import characters.melee.Barbarian;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {
    private Barbarian barbarian;
    private Weapon weapon1;
    private Weapon weapon2;
    private Orc orc;

    @Before
    public void before(){
        barbarian = new Barbarian("Arthur", 5);
        weapon1 = new Weapon("Sword", 3);
        weapon2 = new Weapon("Axe", 2);
        orc = new Orc("Orc", 5, 1, 1);

    }

    @Test
    public void barbarianNameAndHealth(){
        assertEquals("Arthur", barbarian.getName());
        assertEquals(5, barbarian.getCurrentHealth());
        assertEquals(5, barbarian.getMaxHealth());
    }

    @Test
    public void canAddWeapon(){
        barbarian.addWeaponToWeapons(weapon1);
        assertEquals(1, barbarian.getWeapons().size());
    }

    @Test
    public void canChangeWeapon(){
        barbarian.addWeaponToWeapons(weapon1);
        barbarian.addWeaponToWeapons(weapon2);
        barbarian.changeSelectedWeapon(weapon1);
        assertEquals(weapon1, barbarian.getSelectedWeapon());
    }

    @Test
    public void cannotChangeWeaponDontHaveIt(){
        barbarian.changeSelectedWeapon(weapon1);
        assertEquals(null, barbarian.getSelectedWeapon());
    }

    @Test
    public void canAttack(){
        barbarian.addWeaponToWeapons(weapon1);
        barbarian.changeSelectedWeapon(weapon1);
        barbarian.attack(orc);
        assertEquals(2, orc.getCurrentHealth());
    }
}
