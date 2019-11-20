package leetcode.dp.maximalsubsquare;

public class MaximalSubRectangle {

    public static void main(String[] args) {
        System.out.println("getMaxRectFromHistogram({1,0,2,3,2,1,0,3}) = " +
                getMaxRectFromHistogram(new int[]{1, 0, 2, 3, 2, 2, 0, 3}));

        System.out.println("getMaxRectFromHistogram({1,0,2,3,2,1,0,3}) = " +
                getMaxRectFromHistogram(new int[]{2, 1, 5, 6, 2, 3}));
    }

    //TODO - learn this
    public static int getMaxRectFromHistogram(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        return 0;
    }
}
