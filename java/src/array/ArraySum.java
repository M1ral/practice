package array;

import java.util.*;

public class ArraySum {

    public static void main(String[] args) {
        System.out.println("findTwoSum : " + Arrays.toString(findTwoSum(new int[]{2,7,6,8,9,10}, 9)));
        System.out.println("findThreeSum : " + findThreeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println("findThreeSum : " + threeSum(new int[]{1,2,-2,-1}));
    }

    public static int[] findTwoSum(int[] arr, int target) {
        if (null == arr || arr.length == 0) {
            return new int[]{0,0};
        }

        Map<Integer, Integer> map = new HashMap<>();
        // key = target - arr[i], value = i
        // {[7, 0],[2, 1],[3, 2],...}
        int i = 0;
        for (int n : arr) {
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            } else {
                map.put(target - n, i);
            }
            i++;
        }
        return new int[]{0,0};
    }

    /**
     * Return 3 elements from the input array nums which sum up to zero.
     * 1. Sort the array
     * 2. For each element X, run TwoSum to find elements that sum to -X.
     *
     * @param nums
     * @return List
     */
    public static List<List<Integer>> findThreeSum(int[] nums) {
        if (null == nums || nums.length == 0 || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // 1. sort the array
        Arrays.sort(nums);

        // 2. For each element X, run TwoSum to find elements that sum up to -X
        for (int x : nums) {
            int[] twoSumForX = findTwoSum(nums, x);
            if (null != twoSumForX && twoSumForX.length > 0) {
                result.add(
                        new ArrayList<Integer>() {{
                            add(x);
                            add(nums[twoSumForX[0]]);
                            add(nums[twoSumForX[1]]);
                        }}
                );
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        Set<List<Integer>> result = new HashSet<>();

        int index = 1;
        for (int n : nums) {
            List<Integer> twoSumList = findTwoSum(nums, -n, index);
            index++;
            if (null == twoSumList) {
                continue;
            }
            twoSumList.add(n);
            Collections.sort(twoSumList);
            result.add(twoSumList);
        }

        return new ArrayList(result);
    }

    private static List<Integer> findTwoSum(int[] nums, int target, int currentNumIndex) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        int i = 1;
        Map<Integer, Integer> map = new HashMap();

        for (int n : nums) {
            if (currentNumIndex == i) {
                i++;
                continue;
            }

            if (map.containsKey(n)) {
                return new ArrayList<Integer>(Arrays.asList(n, map.get(n)));
            } else {
                map.put(target - n, n);
            }
            i++;
        }

        return null;
    }
}
