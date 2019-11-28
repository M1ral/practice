package interview.phone.intuit;

public class BinarySearchII {
    public static void main(String[] args) {
        System.out.println("Found target's (2) right most index: "
                + findLastIndexOf(new int[]{2, 2, 3, 3, 4, 5, 5}, 2));
        System.out.println("Found target's (3)  right most index: "
                + findLastIndexOf(new int[]{2, 2, 3, 3, 4, 5, 5}, 3));
        System.out.println("Found target's (5) right most index: "
                + findLastIndexOf(new int[]{2, 2, 3, 3, 4, 5, 5}, 5));
        System.out.println("Found target's (1) right most index: "
                + findLastIndexOf(new int[]{2, 2, 3, 3, 4, 5, 5}, 1));
        System.out.println("Found target's (2) right most index: "
                + findLastIndexOf(new int[]{2, 2, 2, 2, 2, 2, 2}, 2));
    }

    // return the last index of target
    public static int findLastIndexOf(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int low = 0; int high = nums.length - 1;
        int index = binarySearch(nums, target, low, high);

        // if target was not found
        if (index == -1) {
            return -1;
        }

        // go to right to find the index
        int rightMostIndex = binarySearchRight(nums, target, index, high);

        return rightMostIndex;
    }

    // binarysearch (traditional)
    public static int binarySearch(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // 1, 2, 2, 2, 3
    // binarysearchRight (search only on right)
    public static int binarySearchRight(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1; // <---
            }
        }

        // low > high
        // low -> bad value
        // hight -> right postion

        return high;
    }
}
