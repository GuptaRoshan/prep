package arrays;

public class MaxSubArraySlindingWindow {

    static int maxSunArray(int[] nums) {
        int start = 0, end = 0;
        int maxSub = Integer.MIN_VALUE;
        int currSub = 0;

        while (end < nums.length) {
            currSub = currSub + nums[end];
            end++;

            maxSub = Math.max(maxSub, currSub);

            while (currSub < 0) {
                currSub = currSub - nums[start];
                start++;

            }

        }
        return maxSub;

    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.print(MaxSubArraySlindingWindow.maxSunArray(arr));

    }

}
