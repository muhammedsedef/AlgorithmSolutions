import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public Player player;
    public Location location;
    private Scanner input = new Scanner(System.in);

    // start the game
    public void start() {
        System.out.println("Welcome to Adventure Game");
        System.out.println("Please enter a name: ");
        String playerName = input.nextLine();
        this.player = new Player(playerName);

        System.out.println("Welcome to the dark and foggy world!!! " + playerName);
        System.out.println("To start game please select a character.");
        player.selectChar();
        selectLocation();

    }

    public void selectLocation() {
        Location [] locations = {
                new SafeHouse(this.player),
                new ToolStore(this.player),
                new Cave(this.player),
                new Forest(this.player),
                new River(this.player)
        };

        while(true) {
            System.out.println("Please select a location");
            for(Location location : locations) {
                System.out.println(location.getId() + " - " + location.getName() + " --> " + location.getDescription());
            }
            System.out.println("---------------------------------------");

            int selectedLocationId = input.nextInt();
            Location selectedLocation = Arrays.stream(locations)
                    .filter(location -> location.getId() == selectedLocationId)
                    .findFirst()
                    .orElse(null);
            if(selectedLocation == null) {
                System.out.println("Please enter a valid location id!");
            }
            else{
                this.location = selectedLocation;
                System.out.println("Selected Location: " + this.location.getName());
                if(!this.location.onLocation()) {
                    System.out.println("Game Over");
                    break;
                }
                System.out.println("---------------------------------------");
            }
        }
    }
}
