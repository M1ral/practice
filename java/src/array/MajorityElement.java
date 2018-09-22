package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    /**
     * Return list of elements that occur more than n/3 times
     * Use Boyer-Moore algorithm
     *
     * @param nums
     * @return List
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        if (null == nums || nums.length == 0) {
            return list;
        }

        int count1 = 0, count2 = 0, num1 = nums[0], num2 = nums[0], len = nums.length;

        // loop over the loop using Boyer-Moore majority value algorithm
        for (int i = 0; i < len; i++) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // reset counts
        count1 = 0;
        count2 = 0;

        // verify counts
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }

        if (count1 > len/3) {
            list.add(num1);
        }
        if (count2 > len/3) {
            list.add(num2);
        }

        // result
        return list;
    }
}
