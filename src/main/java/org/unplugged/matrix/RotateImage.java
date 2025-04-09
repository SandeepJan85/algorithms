package org.unplugged.matrix;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {

        int[][] matrix = {{5, 1, 9, 11},
                          {2, 4, 8, 10},
                          {13, 3, 6, 7},
                          {15, 14, 12, 16}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotateImage(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Function that rotates a matrix by 90 degrees clockwise
     * @param matrix that needs to be rotated
     */
    public void rotateImage(int[][] matrix) {
        transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                swapHorizontal(matrix, i, j);
            }
        }
    }

    /**
     * Function that creates the transpose of an n * n matrix in place
     * @param matrix that needs to be converted to it's transpose
     */
    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swapDiagonal(matrix, i, j);
            }
        }
    }

    public void swapDiagonal(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] + matrix[j][i];
        matrix[j][i] = matrix[i][j] - matrix[j][i];
        matrix[i][j] = matrix[i][j] - matrix[j][i];
    }

    public void swapHorizontal(int[][] matrix, int i, int j) {
        int rowMaxIndex = matrix[i].length - 1;
        matrix[i][j] = matrix[i][j] + matrix[i][rowMaxIndex - j];
        matrix[i][rowMaxIndex - j] = matrix[i][j] - matrix[i][rowMaxIndex - j];
        matrix[i][j] = matrix[i][j] - matrix[i][rowMaxIndex - j];
    }
}
