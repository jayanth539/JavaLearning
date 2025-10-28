package dsa;

import java.util.Arrays;

// Find the kth smallest element in an array without using arrays built-in functions.
public class SmallestElementInArray {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(k + "th Smallest Element: " + kthSmallest(arr, k));
    }

    private static int kthSmallest(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr[k - 1];
    }
}
