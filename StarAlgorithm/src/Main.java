import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz: ");
        int number = scan.nextInt();

        for(int i = 1; i<=number; i++) {
            for(int j = 1; j<= (number-i); j++) {
                System.out.print(" ");
            }
            for(int k = 1; k<= (2*i)-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
