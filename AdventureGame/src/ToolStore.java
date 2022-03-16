
public class ToolStore extends NormalLocation{

    private Armor [] armors;
    private Weapon [] weapons;

    public ToolStore(Player player) {
        super(2, player, "Tool Store", "This is Tool Store. You can buy armor or weapon");

        this.weapons = new Weapon[]{
                new Gun(),
                new Sword(),
                new Rifle()
        };
        //this.armors = {new LightArmor(), new MediumArmor()};
        this.armors = new Armor[] {
                new LightArmor(),
                new MediumArmor(),
                new HeavyArmor()
        };
    }

    public void menu() {
        System.out.println("Welcome to Tool Store menu. You can buy Weapon or Armor in here!");
        int selectedId = 0;
        while(selectedId != 3) {
            System.out.println("To buy Armor press 1 | To buy Weapon press 2 | To Exit press 3");
            System.out.println("1- Armor List");
            System.out.println("2- Weapon List");
            System.out.println("3- Exit");
            selectedId = Location.input.nextInt();

            switch (selectedId) {
                case 1:
                    showArmors();
                    buyArmor();
                    this.getPlayer().showInfo();
                    break;

                case 2:
                    showWeapons();
                    buyWeapon();
                    this.getPlayer().showInfo();
                    break;

                case 3:
                    System.out.println("You are now exit the Tool Store.");
                    break;

                default:
                    System.out.println("You made an incorrect entry, Try Again!");
            }
        }
    }

    public void showArmors() {
        System.out.println("ID | Armor | Block | Money |");
        System.out.println("---------------------------------------");
        for(Armor armor : armors) {
            System.out.println(
                    armor.getId() + " | " +
                    armor.getName() + " | " +
                    armor.getArmorDefense() + " | " +
                    armor.getMoney()
            );
            System.out.println("---------------------------------------");
        }
    }

    public void showWeapons() {
        System.out.println("ID | Weapon| Damage | Money |");
        System.out.println("---------------------------------------");
        for(Weapon weapon : weapons) {
            System.out.println(
                    weapon.getId() + " | " +
                    weapon.getName() + " | " +
                    weapon.getWeaponDamage() + " | " +
                    weapon.getMoney()
            );
            System.out.println("---------------------------------------");
        }
    }

    public void buyWeapon() {
        System.out.println("Press 0 to Exit!");
        System.out.println("Please enter weapon id number you want to buy");

        int selectedItemId = Location.input.nextInt();
        while(selectedItemId < 0) {
            System.out.println("Please enter valid weapon id!");
            selectedItemId = Location.input.nextInt();
        }

        if(selectedItemId != 0) {
            Weapon selectedWeapon = Weapon.findWeaponById(weapons, selectedItemId);
            if(selectedWeapon == null) {
                System.out.println("No weapon found by entered id: " + selectedItemId + ". Please enter valid item id");
            }else {
                if(this.getPlayer().getCharacter().getMoney() >= selectedWeapon.getMoney()) {
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    int totalDamage = this.getPlayer().getCharacter().getDamage() + selectedWeapon.getWeaponDamage();
                    this.getPlayer().getCharacter().setDamage(totalDamage);
                    int balance = this.getPlayer().getCharacter().getMoney() - selectedWeapon.getMoney();
                    this.getPlayer().getCharacter().setMoney(balance);
                }else {
                    System.out.println("You cannot buy " + selectedWeapon.getName() + ". You don't have enough money");
                }
                System.out.println("You bought a " + selectedWeapon.getName());
            }
        }
    }

    public void buyArmor() {
        System.out.println("Press 0 to Exit!");
        System.out.println("Please enter armor id number you want to buy");

        int selectedItemId = Location.input.nextInt();
        while(selectedItemId < 0) {
            System.out.println("Please enter valid armor id!");
            selectedItemId = Location.input.nextInt();
        }

        if(selectedItemId != 0) {
            Armor selectedArmor = Armor.findArmorById(armors, selectedItemId);
            if(selectedArmor == null) {
                System.out.println("No armor found by entered id: " + selectedItemId + ". Please enter valid item id");
            }else {
                if(this.getPlayer().getCharacter().getMoney() >= selectedArmor.getMoney() ) {
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    int balance = this.getPlayer().getCharacter().getMoney() - selectedArmor.getMoney();
                    this.getPlayer().getCharacter().setMoney(balance);
                }else {
                    System.out.println("You don't enough money to buy " + selectedArmor.getName());
                }
                System.out.println("You bought a " + selectedArmor.getName());
            }
        }
    }

    @Override
    boolean onLocation() {
        System.out.println("Welcome Tool Store");
        menu();
        return true;
    }
}
