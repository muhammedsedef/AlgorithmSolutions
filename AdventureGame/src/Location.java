import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    private String description;
    protected static Scanner input = new Scanner(System.in);

    public Location(int id, Player player, String name, String description) {
        this.id = id;
        this.player = player;
        this.name = name;
        this.description = description;
    }

    abstract boolean onLocation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
