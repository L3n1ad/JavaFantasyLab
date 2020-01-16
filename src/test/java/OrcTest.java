import characters.enemy.Orc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {

    Orc orc;
    Orc orc1;

    @Before
    public void before(){
        orc = new Orc("Orc", 5, 5, 1, 1);
        orc1 = new Orc("Orc", 5, 5, 1,1 );
    }

    @Test
    public void hasName(){
        assertEquals("Orc", orc.getName());
    }

    @Test
    public void hasMaxHealth(){
        assertEquals(5, orc.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth(){
        assertEquals(5, orc.getCurrentHealth());
    }

    @Test
    public void hasAttackPower(){
        assertEquals(1, orc.getAttackPower());
    }

    @Test
    public void hasHealtPower(){
        assertEquals(1, orc.getHealPower());
    }

    @Test
    public void canAttack(){
        orc.attack(orc1);
        assertEquals(4, orc1.getCurrentHealth());
    }

    @Test
    public void canHeal(){
        orc.attack(orc1);
        orc1.healSelf();
        assertEquals(5, orc.getCurrentHealth());
    }

    @Test
    public void cannotHeal(){
        orc.healSelf();
        assertEquals(5, orc.getCurrentHealth());
    }



}
