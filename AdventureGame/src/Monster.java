
public abstract class Monster {
    private String name;
    private int id;
    private int damage;
    private int healty;
    private int money;


    public Monster(String name, int id, int damage, int healty, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.healty = healty;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        if(healty < 0) {
            healty = 0;
        }
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
