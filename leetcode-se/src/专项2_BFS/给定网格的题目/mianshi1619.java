package 专项2_BFS.给定网格的题目;

import java.util.ArrayList;
import java.util.List;

public class mianshi1619 {

    /**
     * 面试题 16.19. 水域大小
     * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
     * 由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
     * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
     * 示例：
     * 输入：
     * [
     *   [0,2,1,0],
     *   [0,1,0,1],
     *   [1,1,0,1],
     *   [0,1,0,1]
     * ]
     * 输出： [1,2,4]
     * 提示：
     *
     * 0 < len(land) <= 1000
     * 0 < len(land[i]) <= 1000
     *
     */
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0){
            return null;
        }

        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0){
                    list.add(process(land, i, j, m, n));
                }
            }
        }
        list.sort(null);
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    public int process(int[][] land, int i, int j, int m, int n){
        if (i < 0 || i >= m || j < 0 || j >= n || land[i][j] != 0){
            return 0;
        }

        int area = 1;
        land[i][j] = 1;
        area += process(land, i + 1, j, m, n);
        area += process(land, i + 1, j - 1, m, n);
        area += process(land, i + 1, j + 1, m, n);
        area += process(land, i, j - 1, m, n);
        area += process(land, i, j + 1, m, n);
        area += process(land, i - 1, j, m, n);
        area += process(land, i - 1, j + 1, m, n);
        area += process(land, i - 1, j - 1, m, n);
        return area;
    }


    public static void main(String[] args) {
        int[] integers = new mianshi1619().pondSizes(new int[][]{{0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}});
        for (Integer i :
                integers) {
            System.out.println(i);
        }
    }
}
