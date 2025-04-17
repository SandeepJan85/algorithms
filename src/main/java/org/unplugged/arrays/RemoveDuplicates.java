package org.unplugged.arrays;

import java.util.Arrays;

/**
 * A class that uses 2 pointer implementations to shift duplicate elements in place
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5};
        System.out.println(removeDuplicatesWithAtMost2Unique(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Function that shifts duplicate elements in place by keeping at most 2 duplicate elements of each number
     * in an order.
     *
     * @param elements - increasing order of elements in an array
     * @return - the index which denotes the range[0..n] of unique elements(at most 2 duplicates of a number)
     * in the array
     */
    public static int removeDuplicatesWithAtMost2Unique(int[] elements) {
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < elements.length) {
            if (elements[i] == elements[j]) {
                if (count == 0) {
                    i++;
                    if (i < j) {
                        swapElement (i, j, elements);
                    }
                    count ++;
                }
                j ++;
            } else {
                i ++;
                swapElement (i, j, elements);
                j ++;
                count = 0;
            }
        }
        return i;
    }

    /**
     * Function that swaps the duplicates in place with the unique ones
     *
     * @param elements - increasing order of elements in an array
     * @return - the index which denotes the range[0..n] of unique elements in the array
     */
    public static int removeDuplicates(int[] elements) {
        int i = 0;
        int j = 1;
        while(j < elements.length) {
            if (elements[i] == elements[j]) {
                j++;
            } else {
                i++;
                swapElement(i, j, elements);
                j++;
            }
        }
        return i;
    }

    public static void swapElement(int i, int j, int[] elements) {
        int k = elements[i];
        elements[i] = elements[j];
        elements[j] = k;
    }
}
