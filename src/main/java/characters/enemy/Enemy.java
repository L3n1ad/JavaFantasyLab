package characters.enemy;

import behavior.IAttack;
import characters.Being;

public class Enemy extends Being implements IAttack {

    protected int attackPower;
    protected int healPower;

    public Enemy(String name, int maxHealth, int attackPower, int healPower) {
        super(name, maxHealth);
        this.attackPower = attackPower;
        this.healPower = healPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealPower() {
        return healPower;
    }

    public void attack(Being target){
        target.decreaseHealth(attackPower);
    }

    public void healSelf(){
        increaseHealth(healPower);
    }

}
