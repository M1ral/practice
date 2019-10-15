package leetcoce.array;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{4,5,6,7,8,8,8,8,10,13}, 8)));
    }

    // find first and last position of an element in a sorted array
    // perform binary search to find an element, then,
    // binaarySearchLeft to find starting position of the element
    // binarySearchRight to finf the ending position of the element
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (null == nums || nums.length == 0) {
            return ans;
        }

        int low = 0, high = nums.length - 1;
        int foundIndex = binarySearch(nums, target, low, high);
        if (foundIndex == -1) {
            return ans;
        }

        int left = binarySearchLeft(nums, target, low, foundIndex);
        int right = binarySearchRight(nums, target, foundIndex, high);

        return new int[]{left, right};
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchLeft(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) { //TODO notice here target <= nums[mid]
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int binarySearchRight(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
