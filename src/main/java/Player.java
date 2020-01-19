import characters.Being;

import java.util.ArrayList;

public class Player {

    private int wallet;
    private String name;
    private ArrayList<Being> characters;

    public Player(String name, ArrayList<Being> characters) {
        this.wallet = 0;
        this.characters = characters;
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Being> getCharacters() {
        return characters;
    }

    public void increaseWallet(int value){
        wallet += value;
    }
}
