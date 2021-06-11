package 专项2_BFS.给定网格的题目;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mianshi6169_2 {
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0){
            return null;
        }

        int m = land.length;
        int n = land[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0){
                    Queue<Integer> loc = new LinkedList<>();
                    loc.add(i * n + j);
                    land[i][j] = 2;
                    int area = 1;
                    while (!loc.isEmpty()){
                        Integer id = loc.poll();
                        int row = id / n;
                        int col = id % n;
                        for (int[] direction:directions) {
                            int newR = row + direction[0];
                            int newC = col + direction[1];
                            if (newR >= 0 && newR < m && newC >= 0 && newC < n && land[newR][newC] == 0) {
                                loc.add(newR * n + newC);
                                land[newR][newC] = 2;
                                ++area;
                            }
                        }
                    }
                    list.add(area);
                }
            }
        }
        list.sort(null);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
//        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    public static void main(String[] args) {
        int[] integers = new mianshi6169_2().pondSizes(new int[][]{{0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}});
        for (Integer i :
                integers) {
            System.out.println(i);
        }
    }
}
