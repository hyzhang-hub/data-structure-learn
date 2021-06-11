package dp;

public class lt_494 {
    /**
     * 494. 目标和
     * 给你一个整数数组 nums 和一个整数 target 。
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * 示例 1：
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     * 示例 2：
     * 输入：nums = [1], target = 1
     * 输出：1
     * 提示：
     * 1 <= nums.length <= 20
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     * -1000 <= target <= 100
     */
    public int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        process(nums, 0, target, 0);
        return res;
    }

    public void process(int[] nums, int index, int target, int sum){
        if (index == nums.length){
            if (sum == target){
                res++;
            }
            return;
        }
        process(nums, index + 1, target, sum - nums[index]);
        process(nums, index + 1, target, sum + nums[index]);

    }

    public int findTargetSumWays2(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        int dif = sum - target;
        if (dif < 0 || dif % 2 != 0){
            return 0;
        }
        int n = nums.length, neg = dif / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }



    public static void main(String[] args) {
        int targetSumWays = new lt_494().findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }

}
