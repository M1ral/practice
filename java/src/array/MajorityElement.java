package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    // https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    // Majority vote algorithm
    public static void main(String[] args) {
        System.out.println("n/4 = " + majorityElementNby4(new int[]{1,1,1,2,2,2,3,3,3}));
        System.out.println("n/4 = " + majorityElementNby4(new int[]{1,1,1,1,2,2,3,3,3}));
    }

    /**
     * Return element that occurs more than n/2 times
     * @param nums
     * @return int
     */
    public int majorityElementNby2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int num = 0;
        int count = 0;

        for (int i : nums) {
            if (count == 0) {
                num = i;
                count = 1;
            } else if (i == num) {
                count+=1;
            } else {
                count-=1;
            }
        }
        return num;
    }

    /**
     * Return list of elements that occur more than n/3 times
     * Use Boyer-Moore algorithm
     *
     * @param nums
     * @return List
     */
    public List<Integer> majorityElementNby3(int[] nums) {
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

    public static List<Integer> majorityElementNby4(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int num1=nums[0], num2=nums[0], num3=nums[0], count1=0, count2=0, count3=0;
        for (int n : nums) {
            if (num1 == n) {
                count1++;
            } else if (num2 == n) {
                count2++;
            } else if (num3 == n) {
                count3++;
            } else if (count1 == 0) {
                num1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = n;
                count2++;
            } else if (count3 == 0) {
                num3 = n;
                count3++;
            } else {
                count1--;
                count2--;
                count3--;
            }
        }

        count1 = 0;
        count2 = 0;
        count3 = 0;

        for (int n : nums) {
            if (n == num1)
                count1++;
            else if (n == num2)
                count2++;
            else if (n == num3)
                count3++;
        }

        if (count1 >= nums.length / 3)
            list.add(num1);
        if (count2 >= nums.length / 3)
            list.add(num2);
        if (count3 >= nums.length / 3)
            list.add(num3);

        return list;
    }
}
