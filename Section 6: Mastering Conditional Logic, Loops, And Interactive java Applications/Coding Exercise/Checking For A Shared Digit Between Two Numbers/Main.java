class SharedDigit {
    public static boolean hasSharedDigit(int a, int b){
        // Check if both numbers are two-digit values
        if (a < 10 || a > 99 || b < 10 || b > 99) {
            return false;
        }

        // Extract the digits of the numbers
        int p = a % 10; // ones place of a
        int q = a / 10; // tens place of a
        int r = b % 10; // ones place of b
        int s = b / 10; // tens place of b

        // Check if any digits are shared
        if (p == r || p == s || q == r || q == s) {
            return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(SharedDigit.hasSharedDigit(12, 23));
        System.out.println(SharedDigit.hasSharedDigit(9, 99));
        System.out.println(SharedDigit.hasSharedDigit(15, 55));
    }
}
