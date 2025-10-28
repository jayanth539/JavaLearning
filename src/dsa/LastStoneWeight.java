package dsa;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int arr[] = {2,7,4,1,8,1};
        System.out.println("Last Stone Weight: " + lastStoneWeight(arr));
    }

    private static String lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : arr) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? "0" : String.valueOf(maxHeap.poll());
    }
}
