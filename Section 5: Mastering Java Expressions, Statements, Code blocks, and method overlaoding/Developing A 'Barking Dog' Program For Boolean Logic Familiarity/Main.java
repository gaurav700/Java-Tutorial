class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
       if(hourOfDay < 0 || hourOfDay>23){
            return false;
       }
       
       if(barking && hourOfDay<8 || hourOfDay>22){
            return true;
       }else{
            return false;
       }
        

    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(BarkingDog.shouldWakeUp(true,1));
        System.out.println(BarkingDog.shouldWakeUp(false,2));
        System.out.println(BarkingDog.shouldWakeUp(true,8));
        System.out.println(BarkingDog.shouldWakeUp(true,-1));
    }
}
