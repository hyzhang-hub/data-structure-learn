package 专项2_BFS.给定网格的题目;

import java.util.LinkedList;
import java.util.Queue;

public class lt_1162 {
    /**
     * 1162. 地图分析
     * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。
     * 其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
     *
     * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
     *
     * 如果网格上只有陆地或者海洋，请返回 -1。
     *
     * 示例 1：
     *
     * 输入：[[1,0,1],[0,0,0],[1,0,1]]
     * 输出：2
     * 解释：
     * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
     * 示例 2：
     *
     * 输入：[[1,0,0],[0,0,0],[0,0,0]]
     * 输出：4
     * 解释：
     * 海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
     *
     * 提示：
     * 1 <= grid.length == grid[0].length <= 100
     * grid[i][j] 不是 0 就是 1
     */
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int n = grid.length;
        int maxD = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    maxD = Math.max(maxD, findNearestLand(grid, i, j, n));
                }
            }
        }
        return maxD;
    }

    public int findNearestLand(int[][] grid, int i, int j, int n){
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> los = new LinkedList<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        los.add(new int[]{i, j, 0});
        vis[i][j] = true;
        while (!los.isEmpty()){
            int[] f = los.poll();
            for (int[] direction:directions) {
                int newI = direction[0] + f[0];
                int newJ = direction[1] + f[1];
                if (!(newI >= 0 && newI < n && newJ >= 0 && newJ < n)){
                    continue;
                }
                if (!vis[newI][newJ]){
                    los.add(new int[]{newI, newJ, f[2] + 1});
                    vis[newI][newJ] = true;
                    if (grid[newI][newJ] == 1){
                        return f[2] + 1;

                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int i = new lt_1162().maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        System.out.println(i);
    }
}
