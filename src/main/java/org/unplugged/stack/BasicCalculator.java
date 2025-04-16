package org.unplugged.stack;

/**
 * A class that uses a stack to evaluate an arithmetic expression that constitute of +, - & () on a
 * set of integers
 */
public class BasicCalculator {

    public static void main(String[] args) {
        //(1+(4+5+2)-3)+(6+8)
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("-5+1+2-4-3"));
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
                stack.push(String.valueOf(evaluateExpression(stack)));
            } else {
                if (!part.equals(" ")) {
                    stack.push(part);
                }
            }
        }
        return evaluateExpression(stack);
    }

    /**
     * A function that recursively evaluates an expression
     *
     * @param stack - the stack that has the elements
     * @return
     */
    public static int evaluateExpression(Stack stack) {
        Stack.Node node = stack.pop();
        if (node == null || node.getVal().equals("(")) return 0;
        Stack.Node operatorNode = null;
        if (!node.getVal().equals("-") && !node.getVal().equals("+")) {
            operatorNode = stack.pop();
        }
        if (operatorNode == null || operatorNode.getVal().equals("(")) {
            return Integer.parseInt(node.getVal());
        }
        if (operatorNode.getVal().equals("+")) {
            return evaluateExpression(stack) + Integer.parseInt(node.getVal());
        } else {
            return evaluateExpression(stack) - Integer.parseInt(node.getVal());
        }
    }
}
