class LastDigitChecker {
    public static boolean hasSameLastDigit(int a, int b, int c) {
        // Check if all numbers are valid
        if (!isValid(a) || !isValid(b) || !isValid(c)) {
            return false; // Return false if any number is invalid
        }

        // Check if any two numbers have the same last digit
        if (a % 10 == b % 10 || b % 10 == c % 10 || a % 10 == c % 10) {
            return true;
        }

        return false; // Return false if no match is found
    }

    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(LastDigitChecker.hasSameLastDigit(41, 22, 71));
        System.out.println(LastDigitChecker.hasSameLastDigit(23, 32, 42));
        System.out.println(LastDigitChecker.hasSameLastDigit(9, 99, 999));
        
    }
