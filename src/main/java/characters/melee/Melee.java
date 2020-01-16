package characters.melee;


import characters.Being;
import items.Weapon;

import java.util.ArrayList;

public abstract class Melee extends Being {

    private ArrayList<Weapon> weapons;
    private Weapon selectedWeapon;

    public Melee(String name, int maxHealth, int currentHealth) {
        super(name, maxHealth, currentHealth);
        this.weapons = new ArrayList<Weapon>();
        this.selectedWeapon = null;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }
}
