class TeenNumberChecker {
    public static boolean hasTeen(int a, int b, int c){
        if(isTeen(a) || isTeen(b) || isTeen(c)){
            return true;
        }
        return false;
    }
    
    public static boolean isTeen(int c){
        if(c >= 13 && c<=19){
            return true;
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(TeenNumberChecker.hasTeen(9, 99, 19));
        System.out.println(TeenNumberChecker.hasTeen(23, 15, 42));
        System.out.println(TeenNumberChecker.hasTeen(22, 23, 34));
    }
}
