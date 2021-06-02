package arrayandmath;

public class lt_200 {
    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * 输出：3
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        int M  = grid.length;
        int N = grid[0].length;
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1'){
                    infect(grid, i, j, M, N);
                    res++;
                }
            }
        }
        return res;
    }
    public void infect(char[][] grid, int i, int j, int M, int N){
        if (i < 0 || i >= M || j < 0 || j >= M || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j, M, N);
        infect(grid, i + 1, j, M, N);
        infect(grid, i, j - 1, M, N);
        infect(grid, i, j + 1, M, N);
    }
}
