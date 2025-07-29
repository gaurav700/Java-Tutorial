class EqualSumChecker {
    public static boolean hasEqualSum(int a, int b, int c){
        return a+b == c;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(EqualSumChecker.hasEqualSum(1,1,1));
        System.out.println(EqualSumChecker.hasEqualSum(1,1,2));
    }
}
