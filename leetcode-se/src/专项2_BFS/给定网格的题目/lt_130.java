package 专项2_BFS.给定网格的题目;

public class lt_130 {
    /**
     * 130. 被围绕的区域
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 示例 1：
     * 输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
     * 输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     *
     * 输入：board = [['X']]
     * 输出：[['X']]
     *
     */

    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board, m, n);
            dfs(i, n - 1, board, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i < n - 1; i++) {
            dfs(0, i, board, m, n);
            dfs(m - 1, i, board, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void dfs(int row, int col, char[][] board, int m, int n){
        if (!(row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1)){
            return;
        }
        if (board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'A';
        dfs(row + 1, col, board, m, n);
        dfs(row - 1, col, board, m, n);
        dfs(row, col + 1, board, m, n);
        dfs(row, col - 1, board, m, n);
    }

    public static void main(String[] args) {
        new lt_130().solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
