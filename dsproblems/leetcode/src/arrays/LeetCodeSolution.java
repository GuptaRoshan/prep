package arrays;

public class LeetCodeSolution {

    static public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            res[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        int rightProduct = 1;

        for (int i = n - 1; i < 0; i--) {
            res[i] = rightProduct * res[i];
            rightProduct = rightProduct * nums[i];
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.print(LeetCodeSolution.productExceptSelf(nums));
    }

}
