package org.unplugged.combinations;

import java.util.Arrays;

public class CombinationSum {

    public static void main(String[] a) {
        System.out.println(getNumCombinations(8, new int[]{2, 3, 5}));
    }

    /**
     * Function that returns the number of unique combinations that sum up to the target
     *
     * @param target is the value the candidates need to amount to
     * @param candidates are the distinct values in the array
     * @return
     */
    public static int getNumCombinations(int target, int[] candidates) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) return 0;
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            count = count + getNumCombinations(target - candidates[i],
                    Arrays.copyOfRange(candidates, i, candidates.length));
        }
        return count;
    }
}
