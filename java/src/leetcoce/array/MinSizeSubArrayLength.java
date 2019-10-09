package leetcoce.array;

public class MinSizeSubArrayLength {
    public static void main(String[] args) {
        System.out.println("minSubArrayLen(7, new int[]{}) = " + minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int s, int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int i=0, j=0, sum=0, min = Integer.MAX_VALUE;

        while (j < A.length) {
            sum += A[j++];

            while (sum >= s) {
                min = Math.min(min, j-i);
                sum -= A[i++];
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
