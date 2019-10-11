package programcreek.matrix;

import leetcoce.matrix.SpiralOrder1;

import static leetcoce.matrix.MatrixUtils.generateMatrix;
import static leetcoce.matrix.MatrixUtils.print2D;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4, 4);
        SpiralOrder1.spiralOrder(matrix);
        print2D(matrix);
    }
}
