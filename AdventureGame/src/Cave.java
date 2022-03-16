public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(3, player,
                "Cave",
                new Zombie(),
                "This is cave and there are some zombies. Award --> Food",
                3,
                "food");
    }

}
