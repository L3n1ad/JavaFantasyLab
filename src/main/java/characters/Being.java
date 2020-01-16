package characters;

import items.HealingTools;

public abstract class Being {

    protected String name;
    protected int maxHealth;
    protected int currentHealth;
    protected int wallet;

    public Being(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.wallet = 0;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void decreaseHealth(int value){
            currentHealth -= value;
    }

    public void increaseHealth(int value){
       if ((currentHealth + value) > maxHealth) {
           currentHealth = maxHealth;
       } else {
           currentHealth += value;
       }
    }

    public int getWallet() {
        return wallet;
    }

    public void increaseWallet(int value){
        wallet += value;
    }

}
