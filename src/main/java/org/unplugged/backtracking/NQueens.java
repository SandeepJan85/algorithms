package org.unplugged.backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] a) {
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            grid[i] = new int[4];
        }
        NQueens nQueens = new NQueens();
        nQueens.placeQueensOnGrid(grid, 0, 0);
    }

    public boolean checkLeftDiagonalUp(int[][] grid, int i, int j) {
        if (grid[i][j] == 1) return false;
        if (i - 1 >= 0 && j - 1 >= 0) {
            return checkLeftDiagonalUp(grid, i - 1, j - 1);
        }
        return true;
    }

    public boolean checkRightDiagonalUp(int[][] grid, int i, int j) {
        if (grid[i][j] == 1) return false;
        if (i - 1 >= 0 && j + 1 < grid[i].length) {
            return checkRightDiagonalUp(grid, i - 1, j + 1);
        }
        return true;
    }

    public boolean checkVerticalUp(int[][] grid, int i, int j) {
        if (grid[i][j] == 1) return false;
        if (i - 1 >= 0) {
            return checkVerticalUp(grid, i - 1, j);
        }
        return true;
    }

    public boolean isPositionAvailable(int[][] grid, int i, int j) {
        return checkLeftDiagonalUp(grid, i ,j) &&
                checkRightDiagonalUp(grid, i ,j) &&
                checkVerticalUp(grid, i, j);
    }

    /**
     * Function that places n queens on the grid so that no 2 queens attack each other
     *
     * @param grid is where the queens would be placed
     * @param i is the row position
     * @param j is the column position
     */
    public void placeQueensOnGrid(int[][] grid, int i, int j) {
        if (isPositionAvailable(grid, i, j)) {
            grid[i][j] = 1;
            if (i == grid.length - 1) {
                for (int[] r : grid) {
                    System.out.println(Arrays.toString(r));
                }
                System.out.println("\n");
            }
            if (i + 1 < grid.length) {
                placeQueensOnGrid(grid, i + 1, 0);
            }
            grid[i][j] = 0;
            if (j + 1 < grid[i].length) {
                placeQueensOnGrid(grid, i, j + 1);
            }
        } else {
            if (j + 1 < grid[i].length) {
                placeQueensOnGrid(grid, i, j + 1);
            }
        }
    }
}
