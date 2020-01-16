import characters.enemy.Orc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {

    Orc orc;
    Orc orc1;

    @Before
    public void before(){
        orc = new Orc("Orc", 5, 1, 1);
        orc1 = new Orc("Orc", 5, 1, 1);
    }

    @Test
    public void hasName(){
        assertEquals("Orc", orc.getName());
    }

    @Test
    public void hasHealth(){
        assertEquals(5, orc.getHealth());
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



}
