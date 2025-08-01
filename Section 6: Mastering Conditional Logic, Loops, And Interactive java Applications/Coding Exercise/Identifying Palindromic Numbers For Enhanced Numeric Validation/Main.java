class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int palindrome = 0;

        if(number<0){
            number = number* -1;
        }
        int num = number;
        
        while(num>0){
            int lastDigit = num%10;
            palindrome = palindrome*10 + lastDigit;
            num= num/10;
        }

        return palindrome==number;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(NumberPalindrome.isPalindrome(101));
        System.out.println(NumberPalindrome.isPalindrome(-101));
        System.out.println(NumberPalindrome.isPalindrome(707));
        System.out.println(NumberPalindrome.isPalindrome(11212));
    }    
}
