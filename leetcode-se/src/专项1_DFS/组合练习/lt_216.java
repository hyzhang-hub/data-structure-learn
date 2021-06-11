package 专项1_DFS.组合练习;

import java.util.*;

public class lt_216 {
    /**
     * 216. 组合总和 III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > 9 || n > 45){
            return res;
        }

        Deque<Integer> recoder = new ArrayDeque<>();
        process(k, n, 1, recoder, res);
        return res;
    }
    
    public void process(int k, int n, int index, Deque<Integer> recoder, List<List<Integer>> res){
        if (n < 0){
            return;
        }
        if (recoder.size() == k){
            if (n == 0){
                res.add(new ArrayList<>(recoder));
                return;
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
                recoder.addLast(i);
                process(k, n - i, i + 1, recoder, res);
                recoder.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_216().combinationSum3(3, 7);
        for (List<Integer> list: lists
             ) {
            for (Integer i:list
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
