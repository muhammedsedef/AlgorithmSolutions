public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    int raund;

    Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.raund = 0;
    }

    void run() {
        if(checkWeight()){
            System.out.println("Game is started");

            while(this.f1.health > 0  && this.f2.health > 0) {
                raund++;
                System.out.println("=== Round " + raund + " ===");

                // f1 hit to f2
                if(f1.isAttack()){
                    System.out.println(f1.name + " attacked");
                    f2.health = f1.hit(f2);
                }
                if(isWin()) break;

                // f2 hit to f1
                if(f2.isAttack()){
                    System.out.println(f2.name + " attacked");
                    f1.health = f2.hit(f1);
                }
                if(isWin()) break;

                printRaundScore();
            }
        } else {
            System.out.println("The weights of the athletes do not match.");
        }
    }

    boolean checkWeight() {
        return (this.f1.weight <= this.maxWeight && this.f1.weight >= minWeight) &&
                (this.f2.weight <= this.maxWeight && this.f2.weight >= minWeight);
    }

    boolean isWin() {
        if(this.f1.health == 0) {
            printRaundScore();
            System.out.println(f2.name + " won the game");
            return true;
        }else if(this.f2.health == 0) {
            printRaundScore();
            System.out.println(f1.name + " won the game");
            return true;
        }
        return false;
    }

    void printRaundScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Remaining Health \t:" + f1.health);
        System.out.println(f2.name + " Remaining Health \t:" + f2.health);
        System.out.println();
    }
}
