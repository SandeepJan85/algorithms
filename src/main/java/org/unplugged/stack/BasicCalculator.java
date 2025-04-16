package org.unplugged.stack;

/**
 * A class that uses a stack to evaluate an arithmetic expression that constitute of +, - & () on a
 * set of integers
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    /**
     * A function that evaluates an expression by pushing elements onto a stack(evaluates expressions
     * within parentheses on the fly during the push)
     *
     * @param expression - the exp that needs to be evaluated
     * @return the value of the evaluated expressions
     */
    public static int calculate(String expression) {
        String[] expParts = expression.split("");
        Stack stack = new Stack();
        for (String part : expParts) {
            if (part.equals(")")) {
                stack.push(String.valueOf(evaluateExpressionWithinParenthesis(stack)));
            } else {
                if (!part.equals(" ")) {
                    stack.push(part);
                }
            }
        }
        return evaluateExpression(stack);
    }

    /**
     * A function that evaluates an expression outside the parentheses
     *
     * @param stack
     * @return
     */
    public static int evaluateExpression(Stack stack) {
        Stack.Node node = stack.pop();
        int total = 0;
        while (node !=null && !node.getVal().equals("(")) {
            if (!node.getVal().equals("-") && !node.getVal().equals("+")) {
                total = Integer.parseInt(node.getVal()) + total;
            }
            if (node.getVal().equals("-")) {
                total = -total;
            }
            node = stack.pop();
        }
        return total;
    }

    /**
     * A function that evaluates an expression within a parentheses
     *
     * @param stack - the stack that has the elements that need to be evaluated
     * @return - the sum of the expression
     */
    public static int evaluateExpressionWithinParenthesis(Stack stack) {
        Stack.Node node = stack.pop();
        int total = 0;
        while (!node.getVal().equals("(")) {
            if (!node.getVal().equals("-") && !node.getVal().equals("+")) {
                total = Integer.parseInt(node.getVal()) + total;
            }
            if (node.getVal().equals("-")) {
                total = -total;
            }
            node = stack.pop();
        }
        return total;
    }
}
