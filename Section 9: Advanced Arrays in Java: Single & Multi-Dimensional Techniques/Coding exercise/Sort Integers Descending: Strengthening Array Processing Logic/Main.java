import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class SortedArray {

    public static Integer[] getIntegers(int n, Scanner sc) {    
        Integer[] arr = new Integer[n]; // Use Integer[] for sorting with comparator
        System.out.println("Enter the elements : ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static Integer[] sortIntegers(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }

    public static void printArray(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of elements you want to enter: ");
        int n = sc.nextInt();
        
        Integer[] arr = SortedArray.getIntegers(n, sc);
        arr = SortedArray.sortIntegers(arr);
        SortedArray.printArray(arr);

        sc.close();
    }
}
