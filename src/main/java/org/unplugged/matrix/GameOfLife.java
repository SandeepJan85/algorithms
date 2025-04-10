package org.unplugged.matrix;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0},
                         {0, 0, 1},
                         {1, 1, 1},
                         {0, 0, 0}};
        transition(board);
        for (int i = 0; i <board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    /**
     * Function that transitions a matrix to it's next state based on the following rules
     * 1. Any live cell having less than 2 alive neighbors or greater than 3 alive
     * neighbors dies - cell value changes to 0
     * 2. Any live cell with 2 or 3 alive neighbors lives on(nothing changes)
     * 3. Any dead cell with exactly 3 alive neighbors lives(cell value changes to 1)
     *
     * Since we have only 0's and 1's and to mitigate the use of additional space, we mark an alive cell
     * that dies with a -1 and a dead cell that lives to 2
     * @param board
     */
    public static void transition(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveNeighbourCount = getAliveNeighborCount(board, i, j);
                if (board[i][j] == 1 || board[i][j] == -1) {
                    if (aliveNeighbourCount != 2 && aliveNeighbourCount != 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (aliveNeighbourCount == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = (board[i][j] == 2 || board[i][j] == 1) ? 1 : 0;
            }
        }
    }

    /**
     * A function that returns the alive neighbors(horizontal, vertical and diagonal) for each
     * cell in the grid
     *
     * @param board
     * @param i is the row position
     * @param j is the jth column in ith row
     * @return the number of alive neighbors for each cell
     */
    public static int getAliveNeighborCount(int[][] board, int i, int j) {
        int aliveNeighborCount = 0;
        if (i - 1 >= 0 && j - 1 >= 0
                && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1)) {
            aliveNeighborCount++;
        }
        if (i - 1 >= 0
                && (board[i - 1][j] == 1 || board[i - 1][j] == -1)) {
            aliveNeighborCount++;
        }
        if (i - 1 >= 0 && j + 1 < board[i].length
                && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1)) {
            aliveNeighborCount++;
        }
        if (j - 1 >= 0
                && (board[i][j - 1] == 1 || board[i][j - 1] == -1)) {
            aliveNeighborCount++;
        }
        if (j + 1 < board[i].length
                && (board[i][j + 1] == 1 && board[i][j + 1] == -1)) {
            aliveNeighborCount++;
        }
        if (i + 1 < board.length && j - 1 >= 0
                && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1)) {
            aliveNeighborCount++;
        }
        if (i + 1 < board.length
                && (board[i + 1][j] == 1 || board[i + 1][j] == -1)) {
            aliveNeighborCount++;
        }
        if (i + 1 < board.length && j + 1 < board[i].length
                && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1)) {
            aliveNeighborCount++;
        }
        return aliveNeighborCount;
    }
}

