import characters.melee.Knight;
import items.Weapon;
import org.junit.Before;

public class KnightTest {

    private Knight knight;
    private Weapon weapon1;
    private Weapon weapon2;

    @Before
    public void before(){
        knight = new Knight("Arthur", 5);
    }

}
