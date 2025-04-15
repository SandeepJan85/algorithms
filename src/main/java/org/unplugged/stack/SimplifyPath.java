package org.unplugged.stack;

public class SimplifyPath {

    public static void main(String[] args) {
        //ex: /home/user/Documents/../Pictures
        System.out.println(simplify("/.../a/../b/c/../d/./"));
    }

    /**
     * A function that breaks down a given path based on the below rules:
     * 1. one or multiple(///) '/'s in the path is considered to be one single '/'
     * 2. '..' denotes the parent directory
     * 3. '.' denotes the current directory
     * 4. '...' is a valid directory
     *
     * @param path - the path which is broken and pushed into the stack
     * @return the path
     */
    public static String simplify(String path) {
        String[] pathParts = path.split("/+");
        Stack stack = new Stack();
        for (String part : pathParts) {
            if (part.equals("..")) {
                if (stack.getLength() > 0) {
                    stack.pop();
                }
            } else {
                if (!part.equals(".") && !part.isEmpty()) {
                    stack.push(part);
                }
            }
        }
        return stack.getLength() == 0 ? "/" : buildPath(stack);
    }

    /**
     * A function that recursively builds the path which begins from the bottom of the stack
     *
     * @param stack - the stack which contains of the path parts used to build the path
     * @return the path
     */
    public static String buildPath(Stack stack) {
        Stack.Node node = stack.pop();
        if (node == null) {
            return "";
        }
        String path = buildPath(stack);
        path = path.concat("/").concat(node.getVal());
        return path;
    }

}
