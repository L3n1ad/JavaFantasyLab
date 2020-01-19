package characters.spellCasters;

import behavior.IAttack;
import characters.Being;
import characters.enemy.Enemy;
import items.Staff;


import java.util.ArrayList;

public abstract class SpellCaster extends Being implements IAttack{

    private ArrayList<Staff> staffs;
    private Staff selectedStaff;

    public SpellCaster(String name, int maxHealth) {
        super(name, maxHealth);
        this.staffs = new ArrayList<Staff>();
        this.selectedStaff = null;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public Staff getSelectedStaff() {
        return selectedStaff;
    }

    public void attack(Being target){
            target.decreaseHealth(selectedStaff.getDamage());
    }

    public void attackGroup(ArrayList<Enemy> enemies){
        for(Enemy enemy : enemies){
            attack(enemy);
        }
    }

    public void addStaffToStaffs(Staff weapon){
        staffs.add(weapon);
    }

    public void changeSelectedStaff(Staff weapon){
        if(staffs.contains(weapon)){
            selectedStaff = weapon;
        }
    }
}
