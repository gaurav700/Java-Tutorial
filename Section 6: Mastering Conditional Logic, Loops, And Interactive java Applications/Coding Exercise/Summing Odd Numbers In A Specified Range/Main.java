class SumOddRange{
    public static boolean isOdd(int number){
        if(number <= 0){
            return false;
        }
        if(number % 2 == 0){
            return false;
        }
        return true;
    }
    public static int sumOdd(int start, int end){
        if(start > end){
            return -1;
        }
        int sum = 0;
        for(int i = start; i <= end; i++){
            if(isOdd(i)){
                sum += i;
            }
        }
        return sum;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(SumOddRange.sumOdd(1, 100));
        System.out.println(SumOddRange.sumOdd(-1, 100));
        System.out.println(SumOddRange.sumOdd(100, 100));
        System.out.println(SumOddRange.sumOdd(13, 13));
        System.out.println(SumOddRange.sumOdd(100, -100));
    }
}
