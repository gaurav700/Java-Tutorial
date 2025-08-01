class GreatestCommonDivisor {
    // write code here
    public static int getGreatestCommonDivisor(int first, int second){
        if(first<10 || second< 10){
            return -1;
        }
        int num=0;
        if(first>second){
            num = second;
        }else{
            num = first;
        }
        
        int gcd = 0;
        
        for(int i=1;i<=num;i++){
            if(first%i == 0 && second%i == 0){
                gcd = i;
            }
        }
        
        return gcd;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(12, 30));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(25, 15));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(30, 12));
    }
}
    