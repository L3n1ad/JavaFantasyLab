package characters.spellCasters;

import characters.Being;
import characters.enemy.Enemy;
import items.Staff;


import java.util.ArrayList;

public class SpellCaster extends Being {

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

    public void attack(ArrayList<Enemy> enemies){
        for(Enemy enemy : enemies){
            enemy.decreaseHealth(selectedStaff.getDamage());
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
