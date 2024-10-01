package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int x= arr[i];
            int pos = i;
            while(pos >0 && x<arr[pos -1]){
                arr[pos]= arr[pos-1];
                pos --;
            }
            arr[pos] = x;
        }
    }
    public static void main(String[] args) {
        int [] arr = {5,6,10,1,2,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
