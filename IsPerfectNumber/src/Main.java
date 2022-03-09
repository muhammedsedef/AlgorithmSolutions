import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = scan.nextInt();

        int total = 0;

        for(int i = 1; i<number; i++) {
            if(number % i == 0) {
                System.out.println("divided number: " + i);
                total+= i;
            }
        }
        if (total == number) {
            System.out.println(number + " is perfect number.");
        } else {
            System.out.println(number + " isnot perfect number.");
        }


    }
}
