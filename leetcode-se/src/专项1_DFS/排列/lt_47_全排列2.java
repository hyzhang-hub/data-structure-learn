package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.List;

public class lt_47_全排列2 {
    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 提示：
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        process(nums, 0, res);
        return res;
    }

    public void process(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        boolean[] isUsed = new boolean[21];
        for (int j = i; j < nums.length; j++) {
            if (!isUsed[nums[j]]){
                isUsed[nums[j]] = true;
                swap(nums, i, j);
                process(nums, i + 1, res);
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_47_全排列2().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list: lists) {
            for (Integer i:list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
