import characters.enemy.Orc;
import characters.melee.Barbarian;
import characters.melee.Dwarf;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

        private Dwarf dwarf;
        private Weapon weapon1;
        private Weapon weapon2;
        private Orc orc;

        @Before
        public void before(){
            dwarf = new Dwarf("Arthur", 5);
            weapon1 = new Weapon("Sword", 3);
            weapon2 = new Weapon("Axe", 2);
            orc = new Orc("Orc", 5, 1, 1);

        }

        @Test
        public void dwarfNameAndHealth(){
            assertEquals("Arthur", dwarf.getName());
            assertEquals(5, dwarf.getCurrentHealth());
            assertEquals(5, dwarf.getMaxHealth());
        }

        @Test
        public void canAddWeapon(){
            dwarf.addWeaponToWeapons(weapon1);
            assertEquals(1, dwarf.getWeapons().size());
        }

        @Test
        public void canChangeWeapon(){
            dwarf.addWeaponToWeapons(weapon1);
            dwarf.addWeaponToWeapons(weapon2);
            dwarf.changeSelectedWeapon(weapon1);
            assertEquals(weapon1, dwarf.getSelectedWeapon());
        }

        @Test
        public void cannotChangeWeaponDontHaveIt(){
            dwarf.changeSelectedWeapon(weapon1);
            assertEquals(null, dwarf.getSelectedWeapon());
        }

        @Test
        public void canAttack(){
            dwarf.addWeaponToWeapons(weapon1);
            dwarf.changeSelectedWeapon(weapon1);
            dwarf.attack(orc);
            assertEquals(2, orc.getCurrentHealth());
        }
}
