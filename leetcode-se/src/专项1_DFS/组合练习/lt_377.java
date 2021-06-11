package 专项1_DFS.组合练习;

public class lt_377 {
    /**
     * 377. 组合总和 Ⅳ
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * 题目数据保证答案符合 32 位整数范围。
     * 示例 1：
     *
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * 示例 2：
     *
     * 输入：nums = [9], target = 3
     * 输出：0
     * 提示：
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 1000
     * nums 中的所有元素 互不相同
     * 1 <= target <= 1000
     *
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0){
            return 0;
        }
        int res = 0;
        int[][] dp = new int[target + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= target; j++) {
                for (int num: nums) {
                    if (j >= num) dp[i][j] += dp[i - 1][j -num];
                }
            }
            res += dp[i][target];
        }
        return res;
    }
    public int combinationSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0){
            return 0;
        }
        int res = 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int u:nums) {
                if (i >= u) dp[i] += dp[i - u];
            }
        }
        return dp[target];
    }

    public void process(int[] nums, int target, int index, int res){
        if (target < 0){
            return;
        }
        if (target == 0){
            res++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] > 0){
                process(nums, target - nums[i], i, res);
            }
        }
    }

    public static void main(String[] args) {
        int i = new lt_377().combinationSum5(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }
}
