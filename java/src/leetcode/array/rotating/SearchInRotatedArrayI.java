package leetcode.array.rotating;

import static leetcode.array.rotating.RotatingArray.rotateArray;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedArrayI {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray(nums, 3);

        System.out.println("search(nums, 6) = " + search(nums, 6));
        System.out.println("search(nums, 2) = " + search(nums, 2));
        System.out.println("search(nums, 12) = " + search(nums, 12));
    }

    /**
     * Binary search on a rotating leetcode.array - {5,6,7,1,2,3,4}
     *
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (target == nums[mid])
                return mid;

            // rotation; the middle element in left
            if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            // rotation; the middle element in right
            else if (nums[mid] < nums[l]) {
                if (nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            // no rotation; normal binary search
            else {
                if (target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
}

