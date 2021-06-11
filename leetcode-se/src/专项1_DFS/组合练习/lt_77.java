package 专项1_DFS.组合练习;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lt_77 {
    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        process(n, 1, k, path, res);
        return res;
    }

    public void process(int n, int index, int k, Deque<Integer> path, List<List<Integer>> res){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            process(n, i + 1, k, path, res);
            path.removeLast();
        }
    }

    public void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res){
        if (k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (begin > n - k + 1){
            return;
        }

        dfs(begin + 1, n, k, path, res);
        path.addLast(begin);
        dfs(begin + 1, n, k - 1, path, res);
        path.removeLast();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_77().combine(7, 4);
        for (List<Integer> list:lists) {
            for (Integer i:list
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
