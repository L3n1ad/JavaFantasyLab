import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.enemy.Troll;
import characters.spellCasters.FireWizard;
import items.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IceWizardTest {
    private FireWizard wizard;
    private Staff staff1;
    private Staff staff2;
    private Orc orc;
    private Troll troll;
    private ArrayList<Enemy> enemies;

    @Before
    public void before(){
        wizard = new FireWizard("FireWizard", 5);
        staff1 = new Staff("staff1", 2);
        staff2 = new Staff("staff2", 3);
        orc = new Orc("Orc1", 5, 1, 1);
        troll = new Troll("Orc2", 5, 1, 1);
        enemies = new ArrayList<Enemy>();
        enemies.add(orc);
        enemies.add(troll);
    }

    @Test
    public void wizardNameAndHealth(){
        assertEquals("FireWizard", wizard.getName());
        assertEquals(5, wizard.getCurrentHealth());
        assertEquals(5, wizard.getMaxHealth());
    }

    @Test
    public void canAddWeapon(){
        wizard.addStaffToStaffs(staff1);
        assertEquals(1, wizard.getStaffs().size());
    }

    @Test
    public void canChangeWeapon(){
        wizard.addStaffToStaffs(staff1);
        wizard.addStaffToStaffs(staff2);
        wizard.changeSelectedStaff(staff1);
        assertEquals(staff1, wizard.getSelectedStaff());
    }

    @Test
    public void cannotChangeWeaponDontHaveIt(){
        wizard.changeSelectedStaff(staff1);
        assertEquals(null, wizard.getSelectedStaff());
    }

    @Test
    public void canAttack(){
        wizard.addStaffToStaffs(staff1);
        wizard.changeSelectedStaff(staff1);
        wizard.attack(orc);
        assertEquals(3, orc.getCurrentHealth());
    }
}
