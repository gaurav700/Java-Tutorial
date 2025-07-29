class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes<0){
            System.out.println("Invalid Value");
            return;
        }
        int mb = kiloBytes/1024;
        int kb = kiloBytes%1024;
        System.out.println(kiloBytes+" KB = "+mb+" MB and "+kb+" KB" );
    }
}
public class Main {
    public static void main(String[] args) {
        MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
        MegaBytesConverter.printMegaBytesAndKiloBytes(-1024);
        MegaBytesConverter.printMegaBytesAndKiloBytes(5000);
    }
}
