package characters;

import characters.melee.Knight;
import items.HealingTools;

import java.util.ArrayList;

public class Healer extends Being{

    private ArrayList<HealingTools> healingItems;

    public Healer(String name, int maxHealth) {
        super(name, maxHealth);
        this.healingItems = new ArrayList<HealingTools>();
    }

    public ArrayList<HealingTools> getHealingItems() {
        return healingItems;
    }

    public void addHealingItem(HealingTools newItem){
        healingItems.add(newItem);
    }


    public void heal(Being target, HealingTools item) {
        if(healingItems.contains(item)){
            target.increaseHealth(item.getPower());
            healingItems.remove(item);
        }
    }
}
