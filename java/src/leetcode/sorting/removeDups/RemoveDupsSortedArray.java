package leetcode.sorting.removeDups;

public class RemoveDupsSortedArray {

    public static void main(String[] args) {
        System.out.println("removeDups(new int[]{1,2,2,3,3,3,4}) = " +
                removeDups(new int[]{1, 2, 2, 3, 3, 3, 4}));
    }

    public static int removeDups(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > (nums[i-1])) {
                nums[i++] = n;
            }
        }

        return i;
    }
}
