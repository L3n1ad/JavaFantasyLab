import characters.Healer;
import characters.melee.Knight;
import items.HealingTools;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HealerTest {

    private Healer healer;
    private Knight knight;
    private HealingTools potion;

    @Before
    public void before(){
        healer = new Healer("Gandalf", 5);
        knight = new Knight("Arthur", 5);
        potion = new HealingTools ("Healing Potion", 2);
    }

    @Test
    public void healerTest(){
        assertEquals("Gandalf", healer.getName());
        assertEquals(5, healer.getCurrentHealth());
        assertEquals(0, healer.getHealingItems().size());
    }

    @Test
    public void addHealingItemToHealer(){
        healer.addHealingItem(potion);
        assertEquals(1, healer.getHealingItems().size());
    }

    @Test
    public void canHeal(){
        knight.decreaseHealth(2);
        healer.addHealingItem(potion);
        healer.heal(knight, potion);
        assertEquals(5, knight.getCurrentHealth());
        assertEquals(0, healer.getHealingItems().size());
    }

    @Test
    public void cannotHealDontHaveItem(){
        knight.decreaseHealth(2);
        healer.heal(knight, potion);
        assertEquals(3, knight.getCurrentHealth());
        assertEquals(0, healer.getHealingItems().size());
    }

    @Test
    public void canHealToMaxHealthOnly(){
        knight.decreaseHealth(1);
        healer.addHealingItem(potion);
        healer.heal(knight, potion);
        assertEquals(5, knight.getCurrentHealth());
        assertEquals(0, healer.getHealingItems().size());
    }
}
