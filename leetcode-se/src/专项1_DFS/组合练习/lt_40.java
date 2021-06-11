package 专项1_DFS.组合练习;

import java.util.*;

public class lt_40 {
    /**
     * 40. 组合总和 II
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);//剪枝的关键
        Deque<Integer> record = new LinkedList<>();

        process(candidates, 0, target, record, res);
        return res;
    }

    public void process(int[] candidates, int index, int target, Deque<Integer> record, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(record));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //大剪枝：减去candidate[i]小于0，减去后面的candidate[i + 1]、cadidate[i + 2]肯定也小于
            if (target - candidates[i] < 0){
                break;
            }
            //小剪枝：同一层数值相同的节点，从第二个开始，结果一定发生重复，所以跳过
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            record.addLast(candidates[i]);
            process(candidates, i + 1, target - candidates[i], record, res);
            record.removeLast();

        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list:lists
             ) {
            for (Integer i :
                    list) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }
}
