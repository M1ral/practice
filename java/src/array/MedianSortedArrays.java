package array;

public class MedianSortedArrays {

    public static void main(String[] args) {
        System.out.println("median: " + findMedianSortedArraysBruteForce(new int[]{1,2}, new int[]{3}));
        System.out.println("median: " + findMedianSortedArraysImprovised(new int[]{1,2}, new int[]{3}));
    }

    public static double findMedianSortedArraysImprovised(int nums1[], int nums2[]) {
        //if nums1 length is greater than switch them so that nums1 is smaller than nums2.
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysImprovised(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minX

            // find max numbers in X and Y on the left partition
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            // find min numbers in X and Y on the right partition
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                // We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY))/2;
                } else {
                    return (double)Math.max(maxX, maxY);
                }
            } else if (maxX > minY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
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
