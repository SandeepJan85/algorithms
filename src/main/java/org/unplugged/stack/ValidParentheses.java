package org.unplugged.stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(validParentheses(str));
    }

    /**
     * A function that checks if a given pair of parentheses is valid
     *
     * @param str - the string that needs to be validates
     * @return a boolean
     */
    public static boolean validParentheses(String str) {
        char[] parentheses = str.toCharArray();
        Stack stack = new Stack();
        for (char ch : parentheses) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(String.valueOf(ch));
            } else {
                Stack.Node node = stack.pop();
                if (node == null) return false;
                if (ch == ')' && !node.getVal().equals("(")) {
                    return false;
                }
                if (ch == '}' && !node.getVal().equals("{")) {
                    return false;
                }
                if (ch == ']' && !node.getVal().equals("[")) {
                    return false;
                }
            }
        }
        return stack.getLength() == 0;
    }
}
