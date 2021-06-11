package 专项1_DFS.子集类;

import java.util.*;

public class lt_90 {
    /**
     * 90. 子集 II
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * 示例 1：
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * 提示：
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0){
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        Deque<Integer> record = new ArrayDeque<>();
        dfs(nums, 0, record, res);
        return new ArrayList<>(res);
    }

    public void process(int[] nums, int index, Deque<Integer> record, List<List<Integer>> res){
        res.add(new ArrayList<>(record));
        HashSet<Integer> isUsed = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!isUsed.contains(nums[i])){
                isUsed.add(nums[i]);
                record.addLast(nums[i]);
                process(nums, i + 1, record, res);
                record.removeLast();
            }
        }
    }

    public void dfs(int[] nums, int index, Deque<Integer> record, Set<List<Integer>> res){
        if (index == nums.length){
            res.add(new ArrayList<>(record));
            return;
        }

        record.addLast(nums[index]);
        dfs(nums, index + 1, record, res);

        record.removeLast();
        dfs(nums, index + 1, record, res);
    }



    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_90().subsetsWithDup(new int[]{2, 2, 2, 1, 2});
        for (List<Integer> list :lists
                ) {
            for (Integer i :
                    list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
