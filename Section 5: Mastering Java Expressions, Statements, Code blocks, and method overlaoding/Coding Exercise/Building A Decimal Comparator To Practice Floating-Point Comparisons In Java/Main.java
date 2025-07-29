public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int aScaled = (int) (a * 1000);
        int bScaled = (int) (b * 1000);
        return aScaled == bScaled;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0));
    }
}
