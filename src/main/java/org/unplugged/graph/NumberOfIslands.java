package org.unplugged.graph;

/**
 * A class that holds a 2D grid which depicts a combination of land(1s) and water(0s)
 * An island is made up of a combination of 1s that connect together horizontally and vertically
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] board = {{1, 1, 0, 0, 0},
                          {1, 1, 0, 1, 0},
                          {0, 0, 1, 0, 0},
                          {0, 0, 0, 1, 1}};
        System.out.println(findNumberOfIslands(board));
    }

    /**
     * A function that traverses over the grid and identifies the number of islands
     *
     * @param board is the 2D grid
     * @return the number of islands
     */
    public static int findNumberOfIslands(int[][] board) {
        int numIslands = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    identifyIslands(board, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    /**
     * A function that recursively identifies the islands and marks them
     *
     * @param board is the 2D grid
     * @param i is the row position
     * @param j is the jth column in the ith row
     */
    public static void identifyIslands(int[][] board, int i, int j) {
        board[i][j] = 2;
        if (j + 1 < board[i].length && board[i][j + 1] == 1) {
            identifyIslands(board, i, j + 1);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            identifyIslands(board, i, j - 1);
        }
        if (i - 1 >= 0 && board[i - 1][j] == 1) {
            identifyIslands(board, i - 1, j);
        }
        if (i + 1 < board.length && board[i + 1][j] == 1) {
            identifyIslands(board, i + 1, j);
        }
    }
}
