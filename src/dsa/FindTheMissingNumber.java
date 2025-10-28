package dsa;

public class FindTheMissingNumber {

    public static void main(String[] args) {
        int [] a = new int[]{0,2,3};
        System.out.println("The missing number is: " + findMissingNumber(a));
    }

    private static int findMissingNumber(int[] a) {
        int size = a.length;
        int total = size * (size + 1) / 2;
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        return total - sum;
    }
}
