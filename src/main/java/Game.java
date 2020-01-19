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

    public static void chooseWeapon(Being fighter){
        System.out.println("Choose your weapon from the following by typing its name!");
        if(fighter instanceof Melee){
            Weapon weapon = null;
            while(weapon == null){
                for(Weapon weaponOption : ((Melee) fighter).getWeapons()){
                    System.out.println(weaponOption.getName() + " with a damage of " + weaponOption.getDamage());
                }
                Scanner in = new Scanner(System.in);
                String choice = in.nextLine();
                for(Weapon choosenWeapon : ((Melee) fighter).getWeapons()){
                    if(choice.equals(choosenWeapon.getName())){
                        weapon = choosenWeapon;
                        ((Melee) fighter).changeSelectedWeapon(weapon);
                    }
                }
            }
        }
        if(fighter instanceof SpellCaster){
            Staff staff = null;
            while(staff == null){
                for(Staff staffOption : ((SpellCaster) fighter).getStaffs()){
                    System.out.println(staffOption.getName() + " with a damage of " + staffOption.getDamage());
                }
                Scanner in = new Scanner(System.in);
                String choice = in.nextLine();
                for(Staff choosenStaff : ((SpellCaster) fighter).getStaffs()){
                    if(choice.equals(choosenStaff.getName())){
                        staff = choosenStaff;
                        ((SpellCaster) fighter).changeSelectedStaff(staff);
                    }
                }
            }
        }
    }

    public static HealingTools chooseHealingItem(Healer healer){
        HealingTools choosenItem = null;
        if(healer.getHealingItems().size() > 0){
            while(choosenItem == null){
                int optionNum = 1;
                for(HealingTools healingItem : healer.getHealingItems()){
                    System.out.println(optionNum + ". " + healingItem.getName() + " has a power to heal of " + healingItem.getPower());
                    optionNum += 1;
                }
                Scanner in = new Scanner(System.in);
                int choice = Integer.parseInt(in.nextLine());
                if(choice > 0 && choice <= healer.getHealingItems().size()){
                    choosenItem = healer.getHealingItems().get(choice - 1);
                } else {
                    System.out.println("Uppps wrong number please try again!");
                }
            }

        } else {
            System.out.println("UUpppps no more healing potion left....");
        }
        return choosenItem;
    }


    public static HealingTools randomPotionDrop(double chanceToDrop){
        HealingTools loot = null;
        if(Math.random() > chanceToDrop){
            loot = new HealingTools("Bite of Earth", new Random().nextInt(20 + 1) + 20);
        }
        return loot;
    }

    public static Weapon randomWeaponDrop(double chanceToDrop){
        Weapon loot = null;
        if(Math.random() > chanceToDrop){
            loot = new Weapon("Axe of Death", new Random().nextInt(25 + 1) + 25);
        }
        return loot;
    }

    public static Staff randomStaffDrop(double chanceToDrop){
        Staff loot = null;
        if(Math.random() > chanceToDrop){
            loot = new Staff("Soul destroyer", new Random().nextInt(10 + 1) + 25);
        }
        return loot;
    }



    public static void main(String[] args) {
//      system objectsD
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
//      Game objects
        Knight knight = new Knight("Arthur", 100);
        Weapon sword = randomWeaponDrop(0);
        knight.addWeaponToWeapons(sword);
        knight.changeSelectedWeapon(sword);
        FireWizard fireWizard = new FireWizard("Flaming John", 100);
        Staff fireStaff = randomStaffDrop(0);
        fireWizard.addStaffToStaffs(fireStaff);
        fireWizard.changeSelectedStaff(fireStaff);
        Healer healer = new Healer("Healing Eugene", 100);
        HealingTools potion1 = randomPotionDrop(0);
        HealingTools potion2 = randomPotionDrop(0);
        HealingTools potion3 = randomPotionDrop(0);
        healer.addHealingItem(potion1);
        healer.addHealingItem(potion2);
        healer.addHealingItem(potion3);
        ArrayList<Being> characters = new ArrayList<Being>();
        characters.add(knight);
        characters.add(fireWizard);
        characters.add(healer);
//      LEVEL 1
        Orc orc = new Orc("Stinky Gumal", 75, 25, 25);
        Troll troll = new Troll("Minky Biggy", 75, 25,25);
        ArrayList<Enemy> enemiesLevel1 = new ArrayList<Enemy>();
        enemiesLevel1.add(orc);
        enemiesLevel1.add(troll);
        Gold gold = new Gold(20);
        Room level1 = new Room("Chamber of Souls", enemiesLevel1, characters, gold);


        System.out.println("Welcome to our new adventure");
        System.out.println("Please tell me your name:");
        String input = in.nextLine();
        Player player = new Player(input, characters);
        System.out.println("Nice to meet you " + player.getName() + "You have " + player.getWallet() + " Gold");
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
                    chooseWeapon(fighter);
                    if(fighter instanceof Melee){
                        chooseEnemey(enemiesLevel1);
                        ((IAttack) fighter).attack(target);
                        System.out.println(target.getName() + "health went down to " + target.getCurrentHealth() );
                        if(target.getCurrentHealth() <= 0){
                            level1.getEnemies().remove(target);
                            System.out.println(target.getName() + " is destroyed, well done");
                            Weapon loot = randomWeaponDrop(0.5);
                            if(loot != null) {
                                ((Melee) fighter).addWeaponToWeapons(loot);
                                System.out.println(target.getName() + " dropped you something: " + loot.getName() + " with the damage of " + loot.getDamage());
                            }
                        }
                    }
                    if(fighter instanceof SpellCaster){
                        ((SpellCaster) fighter).attackGroup(enemiesLevel1);
                        ArrayList<Enemy> enemiesCopy = new ArrayList<Enemy>(enemiesLevel1);
                        for(Enemy enemy : enemiesCopy){
                            System.out.println(enemy.getName() + "health went down to " + enemy.getCurrentHealth() );
                            if(enemy.getCurrentHealth() <= 0){
                                enemiesLevel1.remove(enemy);
                                System.out.println(enemy.getName() + " is destroyed, well done");
                                Staff loot = randomStaffDrop(0.5);
                                if(loot != null) {
                                    ((SpellCaster) fighter).addStaffToStaffs(loot);
                                    System.out.println(enemy.getName() + " dropped you something: " + loot.getName() + " with the damage of " + loot.getDamage());
                                }
                            }
                        }
                        if(enemiesLevel1.size() > 0){
                            target = enemiesLevel1.get(0);
                        }
                    }
//                    if(enemiesLevel1.size() > 0){
//                        for(Enemy enemy : enemiesLevel1){
//                            if(enemy.getCurrentHealth() <= 0){
//                                level1.getEnemies().remove(enemy);
//                                System.out.println(enemy.getName() + " is destroyed, well done");
//                                if(fighter instanceof Melee){
//                                    Weapon loot = randomWeaponDrop();
//                                    if(loot != null) {
//                                        ((Melee) fighter).addWeaponToWeapons(loot);
//                                        System.out.println(enemy.getName() + " dropped you something: " + loot.getName() + " with the damage of " + loot.getDamage());
//                                    }
//                                }
//                                if(fighter instanceof SpellCaster){
//                                    Staff loot = randomStaffDrop();
//                                    if(loot != null) {
//                                        ((SpellCaster) fighter).addStaffToStaffs(loot);
//                                        System.out.println(enemy.getName() + " dropped you something: " + loot.getName() + " with the damage of " + loot.getDamage());
//                                    }
//                                }
//                            }
//                        }
//                    }
                }
                if(fighter instanceof Healer){
                    HealingTools item = chooseHealingItem(((Healer)fighter));
                    chooseTargetToHeal(characters);
                    ((Healer) fighter).heal(characterToHeal, item);
                    System.out.println("You healed " + characterToHeal.getName() + " to " + characterToHeal.getCurrentHealth());
                    HealingTools loot = randomPotionDrop(0.5);
                    if(loot != null){
                        ((Healer) fighter).addHealingItem(loot);
                        System.out.println("You got a drop: " + loot.getName() + " with healing power of " + loot.getPower());
                    }
                    System.out.println("You have " + ((Healer)fighter).getHealingItems().size() + " left");
                    target = enemiesLevel1.get(0);
                }
                if(enemiesLevel1.size() > 0){
                    target.attack(fighter);
                    System.out.println(target.getName() + " took " + fighter.getName() + " health done to " + fighter.getCurrentHealth());
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
            player.increaseWallet(level1.getTreasure().getValue());
            System.out.println("You Won Congratulations!!!  You won " + level1.getTreasure().getValue() + "!!! You have " + player.getWallet() + " Gold" );
            running = false;
        }
    }
}
