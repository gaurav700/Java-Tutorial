import java.util.Arrays;
class ReverseArray {
    private static void reverse(int[] array){
        int i = 0;
        int j = array.length - 1;
        System.out.println("Array = " + Arrays.toString(array));
        while(i <= j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        System.out.println("Reversed Array = " + Arrays.toString(array)); 
    }
}
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
    }
}
