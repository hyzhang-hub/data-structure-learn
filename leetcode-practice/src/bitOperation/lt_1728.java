package bitOperation;

import java.util.*;

public class lt_1728 {
    /**
     * 1738. 找出第 K 大的异或坐标值
     * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
     * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
     * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] arr = new int[m + 1][n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                arr[i][j] = arr[i - 1][j] ^ arr[i][j - 1] ^ arr[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                res.add(arr[i][j]);
            }
        }

        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });




        return res.get(k - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5,2},
                {1,6}
        };
        int i = new lt_1728().kthLargestValue(matrix, 1);
        System.out.println(i);
    }
}
