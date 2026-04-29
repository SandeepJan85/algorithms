package org.unplugged.backtracking;

import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {
        char[] word = "EDUCATIVE".toCharArray();
        char[][] board = {{'E', 'D', 'E', 'I', 'W'},
                          {'P', 'U', 'F', 'M', 'Q'},
                          {'I', 'C', 'E', 'T', 'E'},
                          {'M', 'A', 'V', 'C', 'A'},
                          {'J', 'T', 'I', 'Z', 'E'}};
        int[][] tracker = new int[board.length][board[0].length];
        boolean wordFound = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                wordFound = findWord(board, tracker, word, i, j, 0);
                if (wordFound) {
                    System.out.println(wordFound);
                    break;
                }
            }
            if (wordFound) break;
        }
        //nThis prints path taken to find the word
        for (int i = 0; i < tracker.length; i++) {
            System.out.println(Arrays.toString(tracker[i]));
        }
    }

    /**
     * Function that searches for a given word in a matrix using backtracking
     *
     * @param board matrix that needs to be traversed for word search
     * @param tracker to keep a track of the cells visited during the traversal
     * @param word is the word to be searched for in the matrix
     * @param i is the row position
     * @param j is the column position
     * @param letter_pos is the position of the letter in the word
     * @return
     */
    public static boolean findWord(char[][] board,
                                   int[][] tracker,
                                   char[] word,
                                   int i,
                                   int j,
                                   Integer letter_pos) {
        if (word.length - 1 == letter_pos &&
            word[letter_pos] == board[i][j]) {
            return true;
        }

        if (board[i][j] != word[letter_pos]) {
            return false;
        }
        tracker[i][j] = 1;
        boolean wordFound = false;
        if (j + 1 < board[i].length && tracker[i][j + 1] == 0) {
            wordFound = findWord(board, tracker, word, i, j + 1, letter_pos + 1);
            if(wordFound) return wordFound;
            tracker[i][j + 1] = 0;
        }
        if (i + 1 < board.length && tracker[i + 1][j] == 0) {
            wordFound = findWord(board, tracker, word, i + 1, j, letter_pos + 1);
            if(wordFound) return wordFound;
            tracker[i + 1][j] = 0;
        }
        if (j - 1 > 0 && tracker[i][j - 1] == 0) {
            wordFound = findWord(board, tracker, word, i, j - 1, letter_pos + 1);
            if(wordFound) return wordFound;
            tracker[i][j - 1] = 0;
        }
        if (i - 1 > 0 && tracker[i - 1][j] == 0) {
            wordFound = findWord(board, tracker, word, i - 1, j, letter_pos + 1);
            if(wordFound) return wordFound;
            tracker[i - 1][j] = 0;
        }
        tracker[i][j] = 0;
        return wordFound;
    }




}
