import behavior.IAttack;
import characters.Being;
import characters.Healer;
import characters.enemy.Enemy;
import characters.enemy.Orc;
import characters.enemy.Troll;
import characters.melee.Knight;
import characters.melee.Melee;
import characters.spellCasters.FireWizard;
import characters.spellCasters.SpellCaster;
import items.HealingTools;
import items.Staff;
import items.Weapon;
import rooms.Room;
import treasure.Gold;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Being fighter;
    private static Enemy target;
    private static Being characterToHeal;


    public Game() {
    }

    public static Being chooseCharacter(ArrayList<Being> characters) {
        fighter = null;
        while (fighter == null) {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your character for the fight! Please type in their name");
            int optionNum = 1;
            for(Being character : characters){
                if(character instanceof Melee){
                    System.out.println(optionNum + " " + character.getName() + " HP: " + character.getCurrentHealth() + " Damage: " + ((Melee)character).getSelectedWeapon().getDamage());
                    optionNum += 1;
                } else if(character instanceof SpellCaster) {
                    System.out.println(optionNum + " " + character.getName() + " HP: " + character.getCurrentHealth() + " Damage: " + (((SpellCaster) character).getSelectedStaff().getDamage()));
                    optionNum += 1;
                } else {
                    System.out.println(optionNum + " " + character.getName() + " HP: " + character.getCurrentHealth() + " Number of Potions: " + ((Healer)character).getHealingItems().size());
                    optionNum += 1;
                }
            }

            String choosenCharacter = in.nextLine();
            for (Being character : characters) {
                String characterName = character.getName();
                if (choosenCharacter.equals(characterName)) {
                    fighter = character;
                    break;
                }
            }
            if (fighter == null) {
                System.out.println("Characters doesn't exist please try again");
            }
        }
        return fighter;
    }

    public static Being chooseTargetToHeal(ArrayList<Being> characters) {
        characterToHeal = null;
        while (characterToHeal == null) {
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your team player to heal");
            int optionNum = 1;
            for(Being character : characters){
                System.out.println(optionNum + " " + character.getName() + " Current Health: " + character.getCurrentHealth() + " Max Health: " + character.getMaxHealth());
                optionNum += 1;
            }

            String choosenCharacter = in.nextLine();
            for (Being character : characters) {
                String characterName = character.getName();
                if (choosenCharacter.equals(characterName)) {
                    characterToHeal = character;
                    break;
                }
            }
            if (fighter == null) {
                System.out.println("Characters doesn't exist please try again");
            }
        }
        return characterToHeal;
    }

    public static Enemy chooseEnemey(ArrayList<Enemy> enemies) {
        target = null;
        while(target == null){
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your enemy! Please type in their name");
            int optionNum = 1;
            for(Enemy enemy : enemies){
                System.out.println(optionNum + " " + enemy.getName());
                optionNum += 1;
            }

            String choosenTarget = in.nextLine();
            for(Enemy enemy : enemies){
                String enemyName = enemy.getName();
                if(choosenTarget.equals(enemyName)){
                    target = enemy;
                    break;
                }
            }
            if(target == null){
                System.out.println("Enemey doesn't exist please try again");
            }
        }
        return target;
    }



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
        HealingTools potion1 = new HealingTools("Potion of Earth", 10);
        HealingTools potion2 = new HealingTools("Potion of Earth", 10);
        HealingTools potion3 = new HealingTools("Potion of Earth", 10);
        healer.addHealingItem(potion1);
        healer.addHealingItem(potion2);
        healer.addHealingItem(potion3);
        ArrayList<Being> characters = new ArrayList<Being>();
        characters.add(knight);
        characters.add(fireWizard);
        characters.add(healer);
//      LEVEL 1
        Orc orc = new Orc("Stinky Gumal", 50, 25, 25);
        Troll troll = new Troll("Minky Biggy", 50, 25,25);
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
            if(character instanceof Melee){
                System.out.println("Name: " + character.getName() + " HP: " + character.getCurrentHealth() + " Damage: " + ((Melee)character).getSelectedWeapon().getDamage());
            } else if(character instanceof SpellCaster) {
                System.out.println("Name: " + character.getName() + " HP: " + character.getCurrentHealth() + " Damage: " + (((SpellCaster) character).getSelectedStaff().getDamage()));
            } else {
                System.out.println("Name: " + character.getName() + " HP: " + character.getCurrentHealth() + " Number of Potions: " + ((Healer)character).getHealingItems().size());
            }

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
            while(level1.getEnemies().size() > 0){
                chooseCharacter(characters);
                if(fighter instanceof IAttack){
                    chooseEnemey(enemiesLevel1);
                    ((IAttack) fighter).attack(target);
                    System.out.println(target.getName() + "health went down to " + target.getCurrentHealth() );
                    if(target.getCurrentHealth() <= 0){
                        level1.getEnemies().remove(target);
                        System.out.println(target.getName() + " is destroyed, well done");
                    }
                }
                if(fighter instanceof Healer){
                    chooseTargetToHeal(characters);
                    if(((Healer)fighter).getHealingItems().size() > 0){
                        ((Healer)fighter).heal(characterToHeal, (((Healer) fighter).getHealingItems().get(0)));
                        System.out.println("You healed " + characterToHeal.getName() + " to " + characterToHeal.getCurrentHealth());
                        System.out.println("You have " + ((Healer)fighter).getHealingItems().size() + " left");
                    } else {
                        System.out.println("UUpppsss no more healing potion left, you couldn't heal your team member");
                    }

                }
                if(level1.getEnemies().size() > 0){
                    Enemy enemy = level1.getEnemies().get(0);
                    enemy.attack(fighter);
                    System.out.println(enemy.getName() + " took " + fighter.getName() + " health done to " + fighter.getCurrentHealth());
                    if(fighter.getCurrentHealth() <= 0){
                        level1.getPlayers().remove(fighter);
                        System.out.println(fighter.getName() + " has been destroyed!!!(so dead)");
                    }
                }
                if(level1.getPlayers().size() == 0){
                    System.out.println("You lost please try again");
                    break;
                }
            }
            System.out.println("You Won Congratulations");
            running = false;
        }

    }


}
