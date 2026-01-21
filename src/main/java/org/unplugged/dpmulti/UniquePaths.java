package org.unplugged.dpmulti;

public class UniquePaths {
    public static void main(String[] a) {
        int row = 2;
        int col = 2;
        int[][] result = new int[row][col];
        uniquePaths(row, col, 0, 0, result);
        System.out.println(result[0][0]);
    }

    /**
     * LC-62: Unique Paths
     *
     * Function to find the number of unique paths in an m * n grid. The start and endpoint of the path are
     * 0,0 and m-1,n-1 respectively. The function uses memoization to remember the already traversed paths in the grid
     *
     * @param m is the num rows in hte grid
     * @param n is the num columns in the grid
     * @param i is the ith row
     * @param j is the jth column
     * @param result is where the paths are memoized
     * @return
     */
    public static int uniquePaths(int m, int n, int i, int j, int[][] result) {
        if (i == m - 1 && j == n - 1) {
            result[i][j] = 1;
            return 1;
        }
        int pathCount = 0;
        if (j + 1 < n) {
            if (result[i][j + 1] != 0) {
                pathCount = pathCount + result[i][j + 1];
            } else {
                pathCount = pathCount + uniquePaths(m, n, i, j + 1, result);
            }

        }
        if (i + 1 < m) {
            if (result[i + 1][j] != 0) {
                pathCount = pathCount + result[i + 1][j];
            } else {
                pathCount = pathCount + uniquePaths(m, n, i + 1, j, result);
            }
        }
        result[i][j] = pathCount;
        return pathCount;
    }
}
