package org.unplugged.combinations;

public class GenerateParentheses {

    public static void main(String[] a) {
        generate("", 0, 0, 3);
    }

    /**
     * Generates valid parentheses for a given input
     *
     * @param up is what builds up to a pair of valid parentheses
     * @param left is the count of left parentheses
     * @param right is the count of right parentheses
     * @param numPairs is the num pairs of parentheses to be generated
     */
    public static void generate(String up, int left, int right, int numPairs) {
        if (left == right && left == numPairs) {
            System.out.println(up);
            return;
        }
        if (right > left || left > numPairs) {
            return;
        }
        up = up.concat("(");
        generate(up, left + 1, right, numPairs);
        up = up.substring(0, up.length() - 1);
        up = up.concat(")");
        generate(up, left, right + 1, numPairs);
    }
}
