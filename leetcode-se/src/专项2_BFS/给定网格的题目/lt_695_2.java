package 专项2_BFS.给定网格的题目;

import java.util.LinkedList;
import java.util.Queue;

public class lt_695_2 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    Queue<Integer> loc = new LinkedList<>();
                    loc.add(i * n + j);
                    grid[i][j] = 0;
                    int area = 1;
                    while (!loc.isEmpty()){
                        Integer id = loc.poll();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 >= 0 && grid[row - 1][col] == 1){
                            loc.add((row - 1) * n + col);
                            grid[row - 1][col] = 0;
                            area++;
                        }
                        if (row + 1 < m && grid[row + 1][col] == 1){
                            loc.add((row + 1) * n + col);
                            grid[row + 1][col] = 0;
                            area++;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == 1){
                            loc.add(row * n + col - 1);
                            grid[row][col - 1] = 0;
                            area++;
                        }
                        if (col + 1 < n && grid[row][col + 1] == 1){
                            loc.add(row * n + col + 1);
                            grid[row][col + 1] = 0;
                            area++;
                        }
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int i = new lt_695_2().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}});
        System.out.println(i);
    }
}
