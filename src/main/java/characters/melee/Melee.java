package characters.melee;


import behavior.IAttack;
import characters.Being;
import characters.enemy.Enemy;
import items.Weapon;

import java.util.ArrayList;

public abstract class Melee extends Being implements IAttack{

    private ArrayList<Weapon> weapons;
    private Weapon selectedWeapon;

    public Melee(String name, int maxHealth) {
        super(name, maxHealth);
        this.weapons = new ArrayList<Weapon>();
        this.selectedWeapon = null;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public void attack(Being target){
        target.decreaseHealth(selectedWeapon.getDamage());
    }

    public void addWeaponToWeapons(Weapon weapon){
        weapons.add(weapon);
    }

    public void changeSelectedWeapon(Weapon weapon){
        if(weapons.contains(weapon)){
            selectedWeapon = weapon;
        }
    }
}
