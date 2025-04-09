package org.unplugged.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that traverses a matrix in spiral order until all the cells have been visited
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        int[][] tracker = new int[matrix.length][matrix[0].length];
        List<Integer> spiralOrderList = new ArrayList<>();
        spiralOrder(matrix, tracker, 0, 0, spiralOrderList);
        System.out.println(spiralOrderList);
    }

    /**
     * Function that recursively traverses a matrix in a spiral order
     *
     * @param matrix the matrix to be traversed
     * @param tracker to keep a track of cells that have already been visited
     * @param i is the row position
     * @param j is the column position
     * @param list is what gets populated with the values of each cell as we traverse
     */
    public static void spiralOrder(int[][] matrix, int[][] tracker, int i, int j, List<Integer> list) {
        list.add(matrix[i][j]);
        tracker[i][j] = 1;
        if ((i == 0 || tracker[i - 1][j] == 1)
                && j + 1 < matrix[i].length
                && tracker[i][j + 1] != 1) {
            spiralOrder(matrix, tracker, i, j + 1, list);
        }
        if (i + 1 < matrix.length && tracker[i + 1][j] != 1) {
            spiralOrder(matrix, tracker, i + 1, j, list);
        }
        if (j - 1 >= 0 && tracker[i][j - 1] != 1) {
            spiralOrder(matrix, tracker, i, j - 1, list);
        }
        if (i - 1 >= 0 && tracker[i - 1][j] != 1 ) {
            spiralOrder(matrix, tracker, i - 1, j, list);
        }
    }

}
