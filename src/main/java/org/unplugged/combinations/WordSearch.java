package org.unplugged.combinations;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

    public static void main(String[] a) {
        String[][] letters = {{"A","B","C","E"},
                              {"S","F","C","S"},
                              {"A","D","E","E"}};
        String word = "ABFSADEESCC";
        System.out.println(wordSearch(letters, word));
    }

    public static boolean wordSearch(String[][] letters, String word) {
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                if(letters[i][j].equals(String.valueOf(word.charAt(0)))) {
                    Map<String, Integer> tracker = new HashMap<>();
                    tracker.put(i + "-" + j, 1);
                    String initWord= word.substring(1);
                    boolean exist = exist(letters, initWord, i, j, tracker);
                    if(exist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean shouldTraverse(int i, int j, String[][] letters,
                                  String word, Map<String, Integer> tracker) {
         if(!tracker.containsKey(i + "-" + j) &&
                letters[i][j].equals(String.valueOf(word.charAt(0)))) {
             tracker.put(i + "-" + j, 1);
             return true;
         }
         return false;
    }

    /**
     * Function that recursively checks for the word in the grid and returns true if it exists
     *
     * @param letters the grid of characters
     * @param word is what has to be searched in the grid
     * @param i th position of the first letter of the word
     * @param j th position of the first letter of the word
     * @param tracker to track the trversal
     * @return
     */
    public static boolean exist(String[][] letters, String word,
                         int i, int j, Map<String, Integer> tracker) {
        if (word.equals("")) return true;
        boolean exist = false;
        if (j + 1 < letters[i].length &&
                shouldTraverse(i, j + 1, letters, word, tracker)) {
            exist = exist || exist(letters, word.substring(1), i, j + 1, tracker);
        }
        if (j - 1 >= 0 && shouldTraverse(i, j - 1, letters, word, tracker)) {
            exist = exist || exist(letters, word.substring(1), i, j - 1, tracker);
        }
        if (i - 1 >= 0 && shouldTraverse(i - 1, j, letters, word, tracker)) {
            exist = exist || exist(letters, word.substring(1), i - 1, j, tracker);
        }
        if (i + 1 < letters.length && shouldTraverse(i + 1, j, letters, word, tracker)) {
            exist = exist || exist(letters, word.substring(1), i + 1, j, tracker);
        }
        return exist;
    }
}
