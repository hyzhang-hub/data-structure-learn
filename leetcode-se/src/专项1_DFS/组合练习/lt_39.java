package 专项1_DFS.组合练习;

import java.util.*;

public class lt_39 {
    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * 提示：
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> record = new LinkedList<>();
        dfs(candidates, 0, target, record, res);
        return res;
    }

    public void dfs(int[] candidates, int index, int target, Deque<Integer> record, List<List<Integer>> res) {
        if (target == 0){
            res.add(new ArrayList<>(record));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0){
                break;
            }
            record.addLast(candidates[i]);
            System.out.println("递归之前 => " + record + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, i, target - candidates[i], record, res);
            record.removeLast();
            System.out.println("递归之后 => " + record);

        }
    }

    public void process(int[] candidates, int index, int target, Deque<Integer> record, List<List<Integer>> res) {
        if (target < 0){
            return;
        }

        if (target == 0){
            res.add(new ArrayList<>(record));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            record.addLast(candidates[i]);
            System.out.println("递归之前 => " + record + "，剩余 = " + (target - candidates[i]));
            process(candidates, i, target - candidates[i], record, res);

            record.removeLast();
            System.out.println("递归之后 => " + record);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_39().combinationSum(new int[]{2, 3, 6, 7}, 8);
        for (List<Integer> list:lists
             ) {
            for (Integer i :
                    list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
