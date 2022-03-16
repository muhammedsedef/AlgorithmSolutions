public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(1, player, "Safe House", "This is a Safe House for you, there are no enemies.");
    }

    @Override
    boolean onLocation() {
        System.out.println("You are in Safe House!");
        System.out.println("Your health is renewed!");
        return false;
    }
}
