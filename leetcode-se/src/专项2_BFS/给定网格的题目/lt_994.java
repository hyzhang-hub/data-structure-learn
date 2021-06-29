package 专项2_BFS.给定网格的题目;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class lt_994 {
    /**
     * 994. 腐烂的橘子
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     * 示例 1：
     *
     * 输入：[[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * 示例 2：
     * 输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * 示例 3：
     * 输入：[[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     * 提示：
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * grid[i][j] 仅为 0、1 或 2
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    int id = i * n + j;
                    queue.add(id);
                    depth.put(id, 0);
                }
            }
        }
        int res = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()){
            int id = queue.poll();
            int x = id / n;
            int y = id % n;
            for (int[] direction:directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n){
                    continue;
                }
                if (grid[newX][newY] == 1){
                    grid[newX][newY] = 2;
                    int newId = newX * n + newY;
                    queue.add(newId);
                    depth.put(newId, depth.get(id) + 1);
                    res = depth.get(newId);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int i = new lt_994().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(i);
    }
}
