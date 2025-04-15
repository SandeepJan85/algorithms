package org.unplugged.graph;

import java.util.Arrays;

public class SurroundedRegions {

    /**
     * What we are doing is traversing through the border and run a DFS for every cell that is a region
     * and mark it with a 'Z' and then traverse through all the cells again to mark the remaining O's to 'X'
     * and the Z's to O
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'X','O','X','X','X'},
                          {'X','O','O','X','X'},
                          {'X','X','O','X','X'},
                          {'X','O','X','O','X'},
                          {'X','O','X','X','X'},
                          {'X','X','X','X','X'}};
        markRegionsConnectedToTheEdgeRegion(board, 0, 0);
        captureSurroundRegion(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void markRegionsConnectedToTheEdgeRegion(char[][] board, int i, int j) {
        if ((i == 0 || j == 0
                || i == board.length - 1 || j == board[i].length - 1)
                && board[i][j] == 'O') {
            identifyAndMarkEdgeRegions(board, i, j);
        }
        if (i == 0 && j + 1 < board[i].length) {
            markRegionsConnectedToTheEdgeRegion(board, i, j + 1);
        }
        if (j == board[i].length - 1 && i + 1 < board.length) {
            markRegionsConnectedToTheEdgeRegion(board, i + 1, j);
        }
        if (i == board.length - 1 && j - 1 >= 0) {
            markRegionsConnectedToTheEdgeRegion(board, i, j - 1);
        }
        if (j == 0 && i - 1 >= 1) {
            markRegionsConnectedToTheEdgeRegion(board, i - 1, j);
        }
    }

    /**
     * A function that traverses through the board to identify regions that need to be captured
     * @param board
     */
    public static void captureSurroundRegion(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * A function that recursively marks a region(Os) as captured
     *
     * @param board
     * @param i is the row position
     * @param j is the jth column in ith row
     * @return
     */
    public static void identifyAndMarkEdgeRegions(char[][] board, int i, int j) {
        board[i][j] = 'Z';
        if (j + 1 < board[i].length && board[i][j + 1] == 'O') {
            identifyAndMarkEdgeRegions(board, i, j + 1);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            identifyAndMarkEdgeRegions(board, i + 1, j);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            identifyAndMarkEdgeRegions(board, i, j - 1);
        }
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            identifyAndMarkEdgeRegions(board, i - 1, j);
        }
    }
}
