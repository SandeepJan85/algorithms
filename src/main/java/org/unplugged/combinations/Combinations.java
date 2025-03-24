package org.unplugged.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] a) {
        List<String> result = new ArrayList<>();
        findSets("", "abc", result);
        System.out.println(result);
        List<List<Integer>> combinations = new ArrayList<>();
        combine(4, 2, 1, new ArrayList<>(), combinations);
        System.out.println(combinations);
    }

    /**
     * Finds all possible sets for a string
     * ex: findSets("", "abc", []]);
     * @param up - unprocessed element
     * @param p - processed element
     * @param result - final result
     */
    public static void findSets(String up, String p, List<String> result) {
        if (up != null && !"".equals(up)) {
            result.add(up);
        }
        for (int i = 0; i < p.length(); i++) {
            findSets(up.concat(String.valueOf(p.charAt(i))), p.substring(i + 1), result);
        }
    }

    /**
     * Finds all possible k combinations within the range 1..n
     * ex: combine(4, 2, 1, [], [[]])
     * @param n - range starting from 1 until n
     * @param k - k combinations
     * @param j - element which needs to be appended to the unprocessed list
     * @param up - unprocessed list which would be eventually built to form a combination
     * @param result - end result
     */
    public static void combine(int n, int k, int j, List<Integer> up, List<List<Integer>> result) {
        for (int i = j; i <= n && up.size() < k; i++) {
            List<Integer> newList = new ArrayList<>(up);
            newList.add(i);
            combine(n, k, i + 1, newList, result);
            if (newList.size() == k) {
                result.add(newList);
            }
        }
    }
}
