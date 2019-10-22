package leetcode.array;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};
        System.out.println("Missing number from leetcoce.array arr1: "+missingNumber(arr1));
        int[] arr2={5,3,1,2};
        System.out.println("Missing number from leetcoce.array arr2: "+missingNumber(arr2));
    }

    private static int missingNumber(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        int n = arr.length + 1;
        int sum = (n * (n+1)) / 2;
        int restSum = 0;

        for (int i : arr) {
            restSum += i;
        }

        return sum - restSum;
    }
}
