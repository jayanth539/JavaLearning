package dsa;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Function to find the maximum in each sliding window of size k
    private static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        int maxIndex = 0;

        // Find the maximum for the first window
        for (int i = 1; i < k; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        result[0] = arr[maxIndex];

        // Slide the window
        for (int i = k; i < n; i++) {
            // If the max is out of the current window, find the new max
            if (maxIndex <= i - k) {
                maxIndex = i - k + 1;
                for (int j = maxIndex + 1; j <= i; j++) {
                    if (arr[j] > arr[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
            result[i - k + 1] = arr[maxIndex];
        }

        return result;
    }
}
