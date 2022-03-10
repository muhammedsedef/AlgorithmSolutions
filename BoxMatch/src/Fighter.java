public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;
    int attackChange;

    Fighter (String name, int damage, int health, int weight, int dodge, int attackChange) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if(dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        }else {
            this.dodge = 0;
        }
        if(attackChange >= 0 && attackChange <= 100) {
            this.attackChange = attackChange;
        }else {
            this.attackChange = 50;
        }
    }

    int hit(Fighter oppenent) {
        // check oppenent can dodge or not
        if(oppenent.isDodge()){
            System.out.println("Attack dodge by " + oppenent.name);
            return oppenent.health;
        }else {
            System.out.println(this.name + " hit " + this.damage + " damage to " + oppenent.name);
        }
        if(oppenent.health - this.damage < 0)
            return 0;

        return oppenent.health - this.damage;
    }

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return this.dodge >= randomNumber;
    }

    boolean isAttack() {
        double randomNumber = Math.random() * 100;
        return this.attackChange >= randomNumber;
    }
}
