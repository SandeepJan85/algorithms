package org.unplugged.graph;

public class NearestExit {
    public static void main(String[] a) {
        char[][] maze = {{'+','.','+','+','+','+','+'},
                         {'+','.','+','.','.','.','+'},
                         {'+','.','+','.','+','.','+'},
                         {'+','.','.','.','.','.','+'},
                         {'+','+','+','+','.','+','.'}};
        int[][] visited = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) {
            visited[i] = new int[maze[i].length];
        }
        int[] entrance = {0, 1};
        System.out.println(findNearestExit(maze, visited, entrance[0], entrance[1], 0));
    }

    /**
     * function to find the nearest number of steps taken to exit the maze from the given position
     *
     * @param maze - the matrix to traverse
     * @param visited - the matrix to track the traversal
     * @param i - ith row in the matrix
     * @param j - jth column in the matrix
     * @param numSteps - the number of steps to exit the maze
     * @return the min number of steps to exit the maze
     */
    public static int findNearestExit(char[][] maze, int[][] visited, int i, int j, int numSteps) {
        visited[i][j] = 1;
        if (visited[i][j] == 1 && numSteps != 0 &&
                (i == 0 || j == 0 || i == maze.length - 1 || j == maze[i].length - 1)) {
            return numSteps;
        }
        int min = Integer.MAX_VALUE;
        if (j + 1 < maze[i].length && maze[i][j + 1] == '.' && visited[i][j + 1] != 1) {
            min = Math.min(min, findNearestExit(maze, visited, i, j + 1, numSteps + 1));
        }
        if (i + 1 < maze.length && maze[i + 1][j] == '.' && visited[i + 1][j] != 1) {
            min = Math.min(min, findNearestExit(maze, visited, i + 1, j, numSteps + 1));
        }
        if (j - 1 >= 0 && maze[i][j - 1] == '.' && visited[i][j - 1] != 1) {
            min = Math.min(min, findNearestExit(maze, visited, i, j - 1, numSteps + 1));
        }
        if (i - 1 >= 0 && maze[i - 1][j] == '.' && visited[i - 1][j] != 1) {
            min = Math.min(min, findNearestExit(maze, visited, i - 1, j, numSteps + 1));
        }
        if (min == Integer.MAX_VALUE && numSteps != 0) {
            return min;
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}
