public abstract class Weapon extends Equipment{
    private int weaponDamage;

    public Weapon(int id, String name, int money, int weaponDamage) {
        super(id, name, money);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public static Weapon findWeaponById(Weapon [] weapons, int id) {
        for(Weapon weapon : weapons) {
            if(weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }
}
