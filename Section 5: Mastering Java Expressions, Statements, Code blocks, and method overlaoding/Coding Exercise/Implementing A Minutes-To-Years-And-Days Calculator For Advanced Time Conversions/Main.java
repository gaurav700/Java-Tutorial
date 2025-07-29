class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        long days = minutes / (60 * 24); // Calculate total days
        long years = days / 365;        // Calculate years
        long remainingDays = days % 365; // Calculate remaining days after years

        System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
    }
}

public class Main {
    public static void main(String[] args) {
        MinutesToYearsDaysCalculator.printYearsAndDays(525600);
        MinutesToYearsDaysCalculator.printYearsAndDays(1051200);
        MinutesToYearsDaysCalculator.printYearsAndDays(561600);
    }
}
