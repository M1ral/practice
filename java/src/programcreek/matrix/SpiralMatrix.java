package programcreek.matrix;

import leetcode.matrix.SpiralOrder1;

import static leetcode.matrix.MatrixUtils.generateMatrix;
import static leetcode.matrix.MatrixUtils.print2D;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4, 4);
        SpiralOrder1.spiralOrder(matrix);
        print2D(matrix);
    }
}
