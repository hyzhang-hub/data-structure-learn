package 专项2_BFS.给定网格的题目;

public class lt_200 {
    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ['1','1','1','1','0'],
     *   ['1','1','0','1','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','0','0','0']
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ['1','1','0','0','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','1','0','0'],
     *   ['0','0','0','1','1']
     * ]
     * 输出：3
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    process(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    public void process(char[][] grid, int i, int j, int m, int n){
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '#';
        process(grid, i - 1, j, m , n);
        process(grid, i + 1, j, m , n);
        process(grid, i, j + 1, m , n);
        process(grid, i, j - 1, m , n);
    }

    public static void main(String[] args) {
        int i = new lt_200().numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }


}
