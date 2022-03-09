import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = scan.nextInt();

        boolean isArmstrong = isArmstrong(number);
        if (isArmstrong == true) {
            System.out.println(number + " is a Armstrong number");
        } else {
            System.out.println(number + " is not a Armstrong number");
        }
    }

    public static int calcStep(int number) {
        int i = 1;
        int step = 1;

        while(number / i > 9) {
            i*= 10;
            step++;
        }
        return step;
    }

    public static int calcPower(int number, int power) {
        int result = 1;
        for(int i = 1; i<=power; i++) {
            result *= number;
        }
        return result;
    }

    public static boolean isArmstrong(int number) {
        int step = calcStep(number);
        int tempNumber = number;
        int result = 0;

        // 407 => 4^3 + 0^3 + 7^3 == 407 ? true : false
        for(int i = 0; i < step; i++) {
            int stepValue = tempNumber % 10;
            result += calcPower(stepValue, step);
            tempNumber /= 10;
        }
        return number == result ? true : false;
    }

}
