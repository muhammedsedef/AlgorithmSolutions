import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private Character character;
    private String name;

    private Character [] characters = {new Samurai(), new Archer(), new Knight()};

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.setInventory(new Inventory());
    }

    public void selectChar() {
        boolean flag = true;
        while(flag) {
            System.out.println("---------------------------------------");
            System.out.println("Character | ID | Damage | Healthy | Money |");
            System.out.println("---------------------------------------");
            for(Character character : characters) {
                System.out.println(
                        character.getName() + " | " +
                                character.getId() + " | " +
                                character.getDamage() + " | " +
                                character.getHealty() + " | " +
                                character.getMoney() + " | ");
            }
            System.out.println("---------------------------------------");

            System.out.println("Please enter character id number you want to select");
            int selectedId = input.nextInt();

            Character selectedCharecter =
                    Arrays.stream(characters)
                            .filter(character -> character.getId() == selectedId)
                            .findFirst()
                            .orElse(null);
            if(selectedCharecter == null) {
                System.out.println("Please enter a valid id!");
            }
            else{
                this.setCharacter(selectedCharecter);
                System.out.println("Selected Character: " + character.getName());
                showInfo();
                flag = false;
                break;
            }
        }

    }

    public void showInfo() {
        String weaponName = this.inventory.getWeapon() == null ? "No Weapon" : this.inventory.getWeapon().getName();
        String armorName = this.inventory.getArmor() == null ? "No Armor" : this.inventory.getArmor().getName();
        int armorDefense = this.inventory.getArmor() == null ? 0 : this.inventory.getArmor().getArmorDefense();

        System.out.println(
                "Weapon: " + weaponName +
                ", Armor: " + armorName +
                ", Armor Defense: " + armorDefense +
                ", Damage: " + character.getDamage() +
                ", Healthy: " + character.getHealty() +
                ", Money: " + character.getMoney());
        System.out.println("---------------------------------------");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
