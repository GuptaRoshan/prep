package arrays;

public class CheckDuplicateInSortedArray {

    static public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[j] != nums[i]) {
                j = j + 1;
                nums[j] = nums[i];
            }
        }
        return ++j;

    }

    public static void main(String[] args) {

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.print(CheckDuplicateInSortedArray.removeDuplicates(nums));
    }

}
