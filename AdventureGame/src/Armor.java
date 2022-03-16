public abstract class Armor extends Equipment{
    private int armorDefense;

    public Armor(int id, String name, int money, int armorDefense) {
        super(id, name, money);
        this.armorDefense = armorDefense;
    }

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }

    public static Armor findArmorById(Armor [] armors, int id) {
        for(Armor armor : armors) {
            if(armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
}
