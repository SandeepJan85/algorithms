package org.unplugged.matrix;

public class Sudoku {

    public static void main(String[] args) {
        char[][] grid = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Sudoku sudoku = new Sudoku();
        System.out.println(sudoku.isValid(grid));
    }

    public boolean isValid(char[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                 if (grid[i][j] != '.') {
                     if (!isNumUniqueInRowRight(grid, grid[i][j], i, j)
                     || !isNumUniqueInColumnDown(grid, grid[i][j], i, j)
                     || !isNumUniqueInSubGrid(grid, grid[i][j], i, j)) return false;
                 }
            }
        }
        return true;
    }

    public boolean isNumUniqueInRowRight(char[][] grid, char val, int i, int j) {
        while (j + 1 < grid[i].length) {
            if (val == grid[i][j + 1]) return false;
            j ++;
        }
        return true;
    }

    public boolean isNumUniqueInColumnDown(char[][] grid, char val, int i, int j) {
        while (i + 1 < grid.length) {
            if (val == grid[i + 1][j]) return false;
            i ++;
        }
        return true;
    }

    public boolean isNumUniqueInSubGrid(char[][] grid, char val, int i, int j) {
        int subgridRow = i / 3;
        int subgridColumn = j / 3;
        int valCount = 0;
        for (int k = subgridRow * 3; k < (subgridRow * 3) + 3; k ++) {
            for (int l = subgridColumn * 3; l < (subgridColumn * 3) + 3; l++) {
                if (val == grid[k][l]) {
                    valCount++;
                    if (valCount > 1) return false;
                }
            }
        }
        return true;
    }
}
