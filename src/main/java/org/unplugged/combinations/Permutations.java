package org.unplugged.combinations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] a) {
        System.out.println( find("", "abc"));
    }

    /**
     * Finds all the permutations for a given string
     *
     * @param up - is something that would build up into each permutation
     * @param p - is against which all the permutations have to be discovered
     * @return - the list which has the permutations
     */
    public static List<String> find(String up, String p) {
         if(p.length() == 0) {
             return List.of(up);
         }
        List<String> result = new ArrayList<>();
         for (int i = 0; i <= up.length(); i++) {
             result.addAll(find(new StringBuffer(up).insert(i, p.charAt(0)).toString(),
                     p.substring(1)));
         }
        return result;
    }
}
