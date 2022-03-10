import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(int number) {
        int tempNumber = number, reverseNumber = 0, lastNumber;
        while (tempNumber != 0) {
            lastNumber = tempNumber % 10;
            System.out.println("----------");
            System.out.println("Last number: " + lastNumber);

            reverseNumber = (reverseNumber * 10) + lastNumber;
            System.out.println("Reverse number: " + reverseNumber);

            tempNumber /= 10;
            System.out.println("temp number: " + tempNumber);
        }

        if(number == reverseNumber)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = scan.nextInt();
        System.out.println(isPalindrome(number));
    }
}
