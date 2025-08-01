class PerfectNumber {
    // write code here
    public static boolean isPerfectNumber(int number){
        if(number<1){
            return false;
        }
        
        
        int sum = 0;
        
        for(int i=1;i<number;i++){
            if(number%i ==0){
                sum+=i;
            }
        }
        
        return sum==number;
    }
}
public class Main{
    public static void main(String[] args) {
            System.out.println(PerfectNumber.isPerfectNumber(6));
            System.out.println(PerfectNumber.isPerfectNumber(28));
            System.out.println(PerfectNumber.isPerfectNumber(5));
            System.out.println(PerfectNumber.isPerfectNumber(-1));
    }
}