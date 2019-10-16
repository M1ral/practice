package leetcoce.array;

public class NonDecreasingArrayWithSingleModification {

    public static void main(String[] args) {
        System.out.println(isNonDecreasing(new int[]{13, 4, 7}));
        System.out.println(isNonDecreasing(new int[]{5, 1, 3, 2, 5}));
    }

    public static boolean isNonDecreasing(int[] nums) {
        if (null == nums || nums.length < 2) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
