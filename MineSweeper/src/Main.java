import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of row of the playground: ");
        int row = input.nextInt();
        System.out.println("Please enter the number of columns of the playground:1 ");
        int col = input.nextInt();

        MineSweeper mineSweeper = new MineSweeper(row, col);
        mineSweeper.run();
    }
}
