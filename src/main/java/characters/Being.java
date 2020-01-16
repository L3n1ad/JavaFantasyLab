package characters;

public abstract class Being {

    protected String name;
    protected int maxHealth;
    protected int currentHealth;

    public Being(String name, int maxHealth, int currentHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
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
        currenctHealth -= value;
    }

    public void increaseHealth(int value){
        health += value;
    }
}
