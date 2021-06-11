package hash;

import java.util.HashMap;
import java.util.Map;

public class lt_525 {
    /**
     * 525. 连续数组
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * 示例 1:
     *
     * 输入: nums = [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
     * 示例 2:
     *
     * 输入: nums = [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     * 提示：
     *
     * 1 <= nums.length <= 105
     * nums[i] 不是 0 就是 1
     */

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(sums[i - 2])){
                map.put(sums[i - 2], i - 2);
            }
            if (map.containsKey(sums[i])){
                ans = Math.max(ans, i - map.get(sums[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0};
        int maxLength = new lt_525().findMaxLength(arr);
        System.out.println(maxLength);
    }
}
