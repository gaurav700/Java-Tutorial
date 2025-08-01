import java.util.Scanner;

public class InputCalculator {
 public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                int number = scanner.nextInt();
                sum += number;
                count++;
            } else {
                break;
            }
            scanner.nextLine(); // handle end of line (enter key)
        }
        long average = Math.round((double) sum / count);
        System.out.println("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }
}
public class Main {
    public static void main(String[] args) {
        InputCalculator.inputThenPrintSumAndAverage();
    }
}
