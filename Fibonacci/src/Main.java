import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = scan.nextInt();

        int first = 0;
        int second = 1;
        int third;
        // 0 1 1 2 3 5 8 13 21 34
        System.out.print(first + " " + second);

        for(int i = 2; i<number; i++){
            third = first + second;
            System.out.print(" " + third);
            first = second;
            second = third;
        }
    }
}
