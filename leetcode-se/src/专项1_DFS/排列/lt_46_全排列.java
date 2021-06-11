package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.List;

public class lt_46_全排列 {
    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * 输入：nums = [1]
     * 输出：[[1]]
     * 提示：
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        process(nums, 0, res);
        return res;
    }

    public void process(int[] nums, int i, List<List<Integer>> res){
        if (i == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }

        boolean[] isUsed = new boolean[21];
        for (int j = i; j < nums.length; j++) {
            if (!isUsed[nums[j] + 10]){
                isUsed[nums[j] + 10] = true;
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
        List<List<Integer>> lists = new lt_46_全排列().permute(new int[]{1, 1, 2});
        for (List<Integer> list: lists) {
            for (Integer i:list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
