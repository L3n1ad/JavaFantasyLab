import characters.enemy.Troll;
import characters.enemy.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrollTest {

    private Troll troll;
    private Troll troll1;

    @Before
    public void before(){
        troll = new Troll("Troll", 5, 5, 1, 1);
        troll1 = new Troll("Troll", 5, 5, 1,1 );
    }

    @Test
    public void hasName(){
        assertEquals("Troll", troll.getName());
    }

    @Test
    public void hasMaxHealth(){
        assertEquals(5, troll.getMaxHealth());
    }

    @Test
    public void hasCurrentHealth(){
        assertEquals(5, troll.getCurrentHealth());
    }

    @Test
    public void hasAttackPower(){
        assertEquals(1, troll.getAttackPower());
    }

    @Test
    public void hasHealtPower(){
        assertEquals(1, troll.getHealPower());
    }

    @Test
    public void canAttack(){
        troll.attack(troll1);
        assertEquals(4, troll1.getCurrentHealth());
    }

    @Test
    public void canHeal(){
        troll.attack(troll1);
        troll1.healSelf();
        assertEquals(5, troll.getCurrentHealth());
    }

    @Test
    public void cannotHeal(){
        troll.healSelf();
        assertEquals(5, troll.getCurrentHealth());
    }
}
