package specials;

public class Power {
    public static void main(String[] args) {
        System.out.println("pow: " + pow(2, 4));
        System.out.println("pow: " + pow(2, -1));

        System.out.println("-- RECURSIVE --");
        System.out.println("pow: " + pow(2, 4));
        System.out.println("pow: " + pow(2, -1));
    }

    public static boolean isPowerOfTwo(int n) {
        return ( n > 0 && (n & (n-1)) == 0);
    }

    public boolean isPowerOfThree(int n) {
        // highest int that can be power of 3
        return n > 0 && 1162261467 % n == 0;
    }

    private static double pow(int x, int pow) {
        if (x == 0) {
            return 0;
        }
        if (pow == 0) {
            return 1;
        }

        double result = 1;
        if (pow > 0) {
            while (pow != 0) {
                result*=x;
                pow--;
            }
        } else {
            while (pow != 0) {
                result/=x;
                pow++;
            }
        }
        return result;
    }

    /**
     * Calculate power in recursive manner
     * x^5 = x^2 * x^2 * x  (number of steps are equal to number of divisions of n by 2 that reaches to zero)
     * Hence, time complexity = log  n
     *                              2
     * @param x
     * @param n
     * @return
     */
    private static double rpow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double half = rpow(x, n/2);

        if (n % 2 == 0) { // even
            return half * half;
        } else if (n > 0) { // odd - positive
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}

