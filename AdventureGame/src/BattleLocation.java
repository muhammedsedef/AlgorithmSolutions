import java.util.Random;

/**
 * Todo : Safehouse a gidince can fullenmeli
 */
public abstract class BattleLocation extends Location{
    private Monster monster;
    private int maxMonsterCount;
    private String award;

    public BattleLocation(int id, Player player, String name, Monster monster, String description, int maxMonsterCount,String award) {
        super(id, player, name, description);
        this.monster = monster;
        this.maxMonsterCount = maxMonsterCount;
        this.award = award;
    }

    public boolean onLocation() {
        int monsterCount = this.generateRandomMonster();
        System.out.println("Your are in " + this.getName() + " now.");
        System.out.println("Be careful " +  monsterCount + " " +  this.monster.getName() + " live here!");
        System.out.println("Press F to Fight or Press E to Exit");
        String selectedCase = Location.input.nextLine().toUpperCase();
        if(selectedCase.equals("F") && combat(monsterCount)) {
            // fight start
            System.out.println("Congratulations, You beat all the " + this.monster.getName() + "s in the " + this.getName());
            return true;
        }
        if(this.getPlayer().getCharacter().getHealty() <= 0) return false;
        return true;
    }

    public boolean combat(int monsterCount) {
        int monsterHealth = this.monster.getHealty();
        int armorDefense = this.getPlayer().getInventory().getArmor() != null ?
                this.getPlayer().getInventory().getArmor().getArmorDefense() : 0;
        for(int i = 1; i <= monsterCount; i++) {
            this.monster.setHealty(monsterHealth);
            playerStats();
            monsterStats(i);
            while(this.monster.getHealty() > 0 && this.getPlayer().getCharacter().getHealty() > 0) {
                // player attack to monster
                System.out.println("You are attacking to " + this.monster.getName());
                this.monster.setHealty(this.monster.getHealty() - this.getPlayer().getCharacter().getDamage());
                afterHit();
                if(this.monster.getHealty() > 0) {
                    //monster attack to player
                    System.out.println(this.getMonster().getName() + " is attacking to you");
                    int monsterAttack = this.monster.getDamage() - armorDefense;
                    if(monsterAttack < 0) monsterAttack = 0;
                    this.getPlayer().getCharacter().setHealty(this.getPlayer().getCharacter().getHealty() - monsterAttack);
                    afterHit();
                }
            }
            // if we beat the monster
            if(this.getMonster().getHealty() < this.getPlayer().getCharacter().getHealty()){
                System.out.println("You defeat the " + this.getMonster().getName());
                int gainedMoney = this.monster.getMoney() * monsterCount;
                this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + gainedMoney);
                System.out.println("You got " + gainedMoney + " money | Total Money : " + this.getPlayer().getCharacter().getMoney());
            }else { // if monster beat us
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        int armorDefense =
                this.getPlayer().getInventory().getArmor() == null ? 0 :
                this.getPlayer().getInventory().getArmor().getArmorDefense();
        System.out.println("--------------- Player Stats ---------------");
        System.out.println(
                "Damage: " + this.getPlayer().getCharacter().getDamage() +
                " \nHealthy: " + this.getPlayer().getCharacter().getHealty() +
                " \nArmor Defense: " + armorDefense +
                " \nMoney: " + this.getPlayer().getCharacter().getMoney());
        System.out.println("---------------------------------------");
    }

    public void monsterStats(int i) {
        System.out.println("--------------- " + this.monster.getName() + " Stats ---------------");
        System.out.println(
                i + ". " + this.monster.getName() +
                " \nDamage: " + this.monster.getDamage() +
                " \nHealthy: " + this.monster.getHealty());
        System.out.println("---------------------------------------");
    }

    public void afterHit() {
        System.out.println("Player Health: " + this.getPlayer().getCharacter().getHealty());
        System.out.println(this.monster.getName() + " Health: " + this.monster.getHealty());
        System.out.println("---------------------------------------");
    }



    public int generateRandomMonster() {
        Random random = new Random();
        return random.nextInt(this.getMaxMonsterCount()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getMaxMonsterCount() {
        return maxMonsterCount;
    }

    public void setMaxMonsterCount(int maxMonsterCount) {
        this.maxMonsterCount = maxMonsterCount;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
