import java.util.Scanner;

class MinimumElement {

    public static int readInteger() {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the number of elements:");
        return scanner.nextInt();
    }

    public static int[] readElements(int num) {
        Scanner scanner = new Scanner(System.in); 
        int[] arr = new int[num]; 
        System.out.println("Enter " + num + " elements:");
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt(); 
        }
        return arr; 
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE; 
        for (int value : arr) {
            if (value < min) {
                min = value; 
            }
        }
        return min; 
    }
}

public class Main {
    public static void main(String[] args) {
        int num = MinimumElement.readInteger();
        int[] arr = MinimumElement.readElements(num);
        int min = MinimumElement.findMin(arr);
        System.out.println("Minimum element is: " + min);
    }
}
