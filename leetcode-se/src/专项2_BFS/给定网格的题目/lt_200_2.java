package 专项2_BFS.给定网格的题目;

import java.util.LinkedList;
import java.util.Queue;

public class lt_200_2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    res++;
                    grid[i][j] = '0';
                    Queue<Integer> nei = new LinkedList<>();
                    nei.add(i * n + j);
                    while (!nei.isEmpty()){
                        int id = nei.poll();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                            nei.add((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1'){
                            nei.add((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                            nei.add(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (row + 1 < n && grid[row][col + 1] == '1'){
                            nei.add(row * n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int i = new lt_200_2().numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }
}
