class Main {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigKilos = bigCount * 5;

        if (bigKilos + smallCount < goal) {
            return false;
        }

        if (bigKilos >= goal) {
            return (goal % 5) <= smallCount;
        } else {
            return (goal - bigKilos) <= smallCount;
        }
    }
}

public class Main{
        public static void main(String[] args) {
        System.out.println(Main.canPack(1, 0, 4));
        System.out.println(Main.canPack(1, 0, 5));
        System.out.println(Main.canPack(0, 2, 1));
    }
}

