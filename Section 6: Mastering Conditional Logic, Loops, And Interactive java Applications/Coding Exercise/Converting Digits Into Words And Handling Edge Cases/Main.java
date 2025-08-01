class NumberToWords{
 // Suggested code may be subject to a license. Learn more: ~LicenseLog:1988915259.
public static void numberToWords(int number){
    if(number < 0){
        System.out.println("Invalid Value");
        return;
    }

    int reversedNumber = reverse(number);
    int originalDigitCount = getDigitCount(number);
    int reversedDigitCount = getDigitCount(reversedNumber);

    while(reversedNumber > 0){
        int lastDigit = reversedNumber % 10;
        switch(lastDigit){
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
        }
        reversedNumber /= 10;
    }

    for(int i = 0; i < originalDigitCount - reversedDigitCount; i++){
        System.out.println("Zero");
    }

    if (number == 0) {
        System.out.println("Zero");
    }
}

public static int reverse(int number){
    int reversedNumber = 0;
    while(number != 0){
        int lastDigit = number % 10;
        reversedNumber = reversedNumber * 10 + lastDigit;
        number /= 10;
    }
    return reversedNumber;
}

public static int getDigitCount(int number){
    if(number < 0){
        return -1;
    }
    if(number == 0){
        return 1;
    }
    int count = 0;
    while(number > 0){
        number /= 10;
        count++;
    }
    return count;
}
    
}

public class Main{
    public static void main(String[] args) {
            NumberToWords.numberToWords(1010);
            NumberToWords.numberToWords(1000);
            NumberToWords.numberToWords(-12);
            NumberToWords.numberToWords(0);
            NumberToWords.numberToWords(123);
    }
}            

