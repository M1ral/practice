package leetcoce.array;

import java.util.ArrayList;
import java.util.List;

public class DisppearedNumbers {
    public static void main(String[] args) {
        System.out.println("findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}) = " + findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            i = i > 0 ? i : -i;
            nums[i - 1] = nums[i - 1] > 0 ? -nums[i - 1] : nums[i - 1];
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }

        return list;
    }
}
