class EvenDigitSum {
    // write code here
    public static int getEvenDigitSum(int number){
        if(number<0) return -1;
        
        int num = number;
        int even = 0;
        while(num>0){
            int lastDigit = num%10;
            if(lastDigit%2 == 0){
                even+=lastDigit;
            }
            num = num/10;
        }
        
        return even;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(EvenDigitSum.getEvenDigitSum(123456789));
        System.out.println(EvenDigitSum.getEvenDigitSum(246810));
        System.out.println(EvenDigitSum.getEvenDigitSum(123355));
    }    
}
