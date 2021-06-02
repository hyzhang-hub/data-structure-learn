package advanced.class01;

public class Code03_Islands {
    /**
     * 岛问题
     * 【 题目】
     * 一个矩阵中只有0和1两种值， 每个位置都可以和自己的上、 下、 左、 右 四个位置相连， 如
     * 果有一片1连在一起， 这个部分叫做一个岛， 求一个矩阵中有多少个岛?
     * 【 举例】
     * 001010
     * 111010
     * 100100
     * 000000
     * 这个矩阵中有三个岛
     * 【 进阶】
     * 如何设计一个并行算法解决这个问题
     * @param m
     * @return
     */
    public static int countIslands(int[][] m){
        if (m == null || m.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1){
                    res++;
                    infect(m, i, j);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j){
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] != 1){
            return;
        }

        m[i][j] = 2;
        infect(m, i - 1, j);
        infect(m, i + 1, j);
        infect(m, i, j + 1);
        infect(m, i, j - 1);

    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }

}
