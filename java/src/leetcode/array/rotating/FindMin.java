package leetcode.array.rotating;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMin {

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }

}
