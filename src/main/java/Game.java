import characters.Being;
import characters.Healer;
import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.enemy.Troll;
import characters.melee.Knight;
import characters.spellCasters.FireWizard;
import items.HealingTools;
import items.Staff;
import items.Weapon;
import rooms.Room;
import treasure.Gold;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
//      system objectsD
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
//      Game objects
        Knight knight = new Knight("Arthur", 100);
        Weapon sword = new Weapon("Arthur's sword", 25);
        knight.addWeaponToWeapons(sword);
        knight.changeSelectedWeapon(sword);
        FireWizard fireWizard = new FireWizard("Flaming John", 100);
        Staff fireStaff = new Staff("Burning Man's torch", 20);
        fireWizard.addStaffToStaffs(fireStaff);
        fireWizard.changeSelectedStaff(fireStaff);
        Healer healer = new Healer("Healing Eugene", 100);
        HealingTools potion = new HealingTools("Potion of Earth", 10);
        healer.addHealingItem(potion);
        ArrayList<Being> characters = new ArrayList<Being>();
        characters.add(knight);
        characters.add(fireWizard);
        characters.add(healer);
//      LEVEL 1
        Orc orc = new Orc("Stinky Gumal", 50, 10, 10);
        Troll troll = new Troll("Minky Biggy", 50, 15,15);
        ArrayList<Enemy> enemiesLevel1 = new ArrayList<Enemy>();
        enemiesLevel1.add(orc);
        enemiesLevel1.add(troll);
        Gold gold = new Gold(20);
        Room level1 = new Room("Chamber of Souls", enemiesLevel1, characters, gold);


        System.out.println("Welcome to our new adventure");
        System.out.println("Please tell me your name:");
        String input = in.nextLine();
        System.out.println("Nice to meet you " + input);
        System.out.println("Please meet with your brave fighters who will help you through this adventures");
        for(Being character : characters){
            System.out.println("Name: " + character.getName());
            System.out.println("HP: " + character.getCurrentHealth());
        }
        System.out.println("Let's see the first room:");
        System.out.println("Your are in: " + level1.getName() + "and the treasure wating for you is " + level1.getTreasure().getValue() + " Gold");
        System.out.println("The enemies in the room are: ");
        for(Enemy enemy : level1.getEnemies()){
            System.out.println("Name: " + enemy.getName() + "with " + enemy.getCurrentHealth() + "HP");
        }

//       Start the fight

        boolean running = true;

        while(running){

        }

    }
}
