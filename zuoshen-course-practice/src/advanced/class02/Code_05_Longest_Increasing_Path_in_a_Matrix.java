package advanced.class02;

public class Code_05_Longest_Increasing_Path_in_a_Matrix {
    /**
     * 给定一个整数矩阵matrix， 每个位置你可以向左、 右、 下、 上移动， 找到其中最长的递增路径。
     * 例如：
     * matrix = [
     * [9,9,4],
     * [6,6,8],
     * [2,1,1]
     * ] 返
     * 回4
     * 最长路径是[1, 2, 6, 9].
     * matrix = [
     * [3,4,5],
     * [3,2,6],
     * [2,2,1]
     * ] 返
     * 回4
     * 最长路径是[1, 2, 6, 9].
     */
    public static int longest(int[][] matrix){
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, process(matrix, i, j));
            }
        }
        return max;
    }

    public static int process(int[][] matrix, int row, int col){
        int path = 1;
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]){
            path = Math.max(path, process(matrix, row, col - 1) + 1);
        }
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]){
            path = Math.max(path, process(matrix, row - 1, col) + 1);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]){
            path = Math.max(path, process(matrix, row + 1, col) + 1);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]){
            path = Math.max(path, process(matrix, row, col + 1) + 1);
        }
        return path;
    }

    public static int longestIncreasingPath(int[][] m){
        if (m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int[][] dp = new int[m.length][m[0].length];
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                max = Math.max(max, maxIncrease(m, dp, i + 1, j, m[i][j]) + 1);
                max = Math.max(max, maxIncrease(m, dp, i, j + 1, m[i][j]) + 1);
                max = Math.max(max, maxIncrease(m, dp, i - 1, j, m[i][j]) + 1);
                max = Math.max(max, maxIncrease(m, dp, i, j - 1, m[i][j]) + 1);
            }
        }
        return max;
    }

    public static int maxIncrease(int[][] m, int[][] dp, int row, int col, int p){
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length || m[row][col] >= p){
            return 0;
        }
        if (dp[row][col] == 0){
            dp[row][col] = maxIncrease(m, dp, row + 1, col, m[row][col]) + 1;
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row, col + 1, m[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row - 1, col, m[row][col]) + 1);
            dp[row][col] = Math.max(dp[row][col], maxIncrease(m, dp, row, col - 1, m[row][col]) + 1);
        }
        return dp[row][col];
    }

}
