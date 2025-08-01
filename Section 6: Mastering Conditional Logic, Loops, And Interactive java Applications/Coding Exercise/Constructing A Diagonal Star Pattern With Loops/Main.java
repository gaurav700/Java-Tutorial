class DiagonalStar{
    public static void print(int n){
        if(n<5){
            System.out.println("Invalid Value");
            return;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n||i==j||j==(n-i+1)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        DiagonalStar.print(8);
    }
}