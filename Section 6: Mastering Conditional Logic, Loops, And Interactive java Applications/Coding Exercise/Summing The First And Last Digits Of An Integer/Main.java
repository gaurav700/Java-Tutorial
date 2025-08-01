class FirstLastDigitSum {
    
    public static int sumFirstAndLastDigit(int number){
        if(number<0){
            return -1;
        }
        
        int num = number;
        
        int last = num%10;
        int rev = 0;
        
        while(num>0){
            int lastDigit = num%10;
            rev = rev*0 + lastDigit;
            num = num/10;
        }
        
        int first = rev%10;
        
        return first+last;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(257));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(6));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(10000));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(1000));
    }
}
