package array;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("binary search: " + binarySearch(5, new int[]{1,3,5,7,9,10,14,18,80}));
        System.out.println("recursive search: " + search(5, new int[]{1,3,5,7,9,10,14,18,80}, 0, 9, 0));

    }

    public static boolean binarySearch(int num, int[] arr) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int start = 0;
        int end = arr.length - 1;
        int med = 0;
        int iterations = 0;

        while (start < end) {
            iterations++;
            med = (start + end) / 2;
            int p = arr[med];

            if (num < p) {
                end = med - 1;
            } else if (num > p) {
                start = med + 1;
            } else if (num == p) {
                System.out.println("iterations = " + iterations);
                return true;
            }
        }

        return false;
    }

    public static boolean search(int n, int[] a, int s, int e, int i) {
        if (null == a || a.length == 0) {
            return false;
        }

        int m = (s + e) / 2;
        int p = a[m];
        i++;
        if (n < p) {
            e = m - 1;
        } else if (n > p) {
            s = m + 1;
        } else if (n == p) {
            System.out.println("iterations = " + i);
            return true;
        }
        return search(n, a, s, e, i);
    }
}
