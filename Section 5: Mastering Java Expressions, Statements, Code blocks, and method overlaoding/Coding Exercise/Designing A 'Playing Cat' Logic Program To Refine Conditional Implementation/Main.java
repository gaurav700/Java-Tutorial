class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if(temperature>=25 && temperature<=45 && summer){
            return true;
        }
        
        if(temperature>=25 && temperature<=35 && !summer){
            return true;
        }
        
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(PlayingCat.isCatPlaying(true, 10));
        System.out.println(PlayingCat.isCatPlaying(false, 36));
        System.out.println(PlayingCat.isCatPlaying(false, 35));
    }
}
