package org.unplugged.stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(reversePolishNotation(tokens));
    }

    public static int reversePolishNotation(String[] tokens) {
        Stack stack = new Stack();
        for(String token : tokens) {
            if (!token.equals("+") &&
                    !token.equals("-") &&
                    !token.equals("*") &&
                    !token.equals("/")) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop().getVal());
                int num1 = Integer.parseInt(stack.pop().getVal());
                int result = switch (token) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> 0;
                };
                stack.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(stack.pop().getVal());
    }
}
