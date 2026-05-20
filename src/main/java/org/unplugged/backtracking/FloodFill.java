package org.unplugged.backtracking;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {{3,3,6,3,6},
                        {6,6,6,6,3},
                        {6,6,6,3,3},
                        {3,3,3,3,6},
                        {3,6,6,6,6}};
        int i = 4;
        int j = 3;
        int target = 7;
        if (grid[i][j] != target) {
            fill(i, j, grid, grid[i][j], target);
        }
        for (int[] val : grid) {
            System.out.println(Arrays.toString(val));
        }
    }

    /**
     * function that continues to fill up the adjacent elements starting from initial position [i][j] in the grid
     * @param i is the row value
     * @param j is the col val
     * @param grid is the matrix that need to be filled
     * @param iVal is the initial value in the grid that needs to be filled with the target value - grid[i][j]
     * @param target is the value that needs to be filled starting from the initial position in the grid - [i][j]
     */
    public static void fill(int i, int j, int[][] grid, int iVal, int target) {
        if (grid[i][j] != iVal) return;
        grid[i][j] = target;
        if (j + 1 < grid[i].length) {
            fill(i, j + 1, grid, iVal, target);
        }
        if (i + 1 < grid.length) {
            fill(i + 1, j, grid, iVal, target);
        }
        if (j - 1 >= 0) {
            fill(i, j - 1, grid, iVal, target);
        }
        if (i - 1 >= 0) {
            fill(i - 1, j, grid, iVal, target);
        }
    }
}
