package array;

public class MedianSortedArrays {

    public static void main(String[] args) {
        System.out.println("median: " + findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((null == nums1 || nums1.length == 0) && (null == nums2 || nums2.length == 0)) {
            return 0.0;
        }
        if (null == nums1 || nums1.length == 0) {
            return getMedian(nums2);
        }
        if (null == nums2 || nums2.length == 0) {
            return getMedian(nums1);
        }

        // 1. merge two sorted arrays
        int[] result = new int[nums1.length + nums2.length];
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = result.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                result[k] = nums1[i];
                i--;
            } else {
                result[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (i >= 0) {
            result[k] = nums1[i];
            i--;
            k--;
        }

        while (j >= 0) {
            result[k] = nums2[j];
            j--;
            k--;
        }

        // 2. get median of the merged sorted array
        return getMedian(result);
    }

    private static double getMedian(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0.0;
        }

        double result = 0.0d;
        if (arr.length % 2 == 0) {
            double i = arr[arr.length / 2];
            double j = arr[(arr.length / 2) - 1];
            result = (i + j) / 2;
        } else {
            result = arr[arr.length / 2];
        }

        return result;
    }
}
