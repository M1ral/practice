package specials;

public class Power {
    public static void main(String[] args) {
        System.out.println("pow: " + pow(2, 4));
        System.out.println("pow: " + pow(2, -1));

        System.out.println("-- RECURSIVE --");
        System.out.println("pow: " + pow(2, 4));
        System.out.println("pow: " + pow(2, -1));
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

    private static double rpow(int x, int n) {
        if (n == 0) {
            return 1;
        } if (n == 1) {
            return x;
        }
        double temp = rpow(x, n/2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}

