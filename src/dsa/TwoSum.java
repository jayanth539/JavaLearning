package dsa;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 19;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Sum of " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }
}
