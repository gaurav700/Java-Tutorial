class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int year = 2020;
        boolean isLeap = LeapYear.isLeapYear(year);
        System.out.println(isLeap);

        year = 2100;
        isLeap = LeapYear.isLeapYear(year);
        System.out.println(isLeap);
    }
}
