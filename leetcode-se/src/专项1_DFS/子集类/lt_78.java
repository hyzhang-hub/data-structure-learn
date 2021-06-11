package 专项1_DFS.子集类;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lt_78 {
    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }

        Deque<Integer> record = new ArrayDeque<>();
        process(nums, 0, record, res);
        return res;
    }

    public void process(int[] nums, int index, Deque<Integer> record, List<List<Integer>> res){
        res.add(new ArrayList<>(record));

        for (int i = index; i < nums.length; i++) {
            record.addLast(nums[i]);
            process(nums, i + 1, record, res);
            record.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new lt_78().subsets(new int[]{1, 2, 2});
        for (List<Integer> list:subsets
             ) {
            for (Integer i :
                    list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
