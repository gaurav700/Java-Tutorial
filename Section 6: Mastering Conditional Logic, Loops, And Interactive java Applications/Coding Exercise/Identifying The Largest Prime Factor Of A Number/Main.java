// Suggested code may be subject to a license. Learn more: ~LicenseLog:748162302.
public class Main {

    public static int getLargestPrime(int number) {
        if (number <= 1) {
            return -1;
        }

        int largestPrime = -1;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    largestPrime = i;
                }
            }
        }
        return largestPrime;
    }

    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));   // Output: 7
        System.out.println(getLargestPrime(217));  // Output: 31
        System.out.println(getLargestPrime(0));    // Output: -1
        System.out.println(getLargestPrime(45));   // Output: 5
        System.out.println(getLargestPrime(-1));   // Output: -1
    }
}
