package leetcode.array.merge;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeTwoSorted {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || nums1.length == 0 ||
                null == nums2 || nums2.length == 0) {
            return;
        }

        int i = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[i] = nums1[m-1];
                m--;
            } else {
                nums1[i] = nums2[n-1];
                n--;
            }
            i--;
        }
    }
}
