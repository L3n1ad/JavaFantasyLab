package characters.enemy;

import characters.Being;

public abstract class Enemy extends Being {

    protected int attackPower;
    protected int healPower;

    public Enemy(String name, int maxHealth, int currentHealth, int attackPower, int healPower) {
        super(name, maxHealth, currentHealth);
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
