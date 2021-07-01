package 专项11_DP.四鸡蛋或者其他物品掉落;

import java.util.HashMap;
import java.util.Map;

public class lt_887 {
    /**
     * 887. 鸡蛋掉落
     * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     * 示例 1：
     * 输入：k = 1, n = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
     * 如果它没碎，那么肯定能得出 f = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
     * 示例 2：
     * 输入：k = 2, n = 6
     * 输出：3
     * 示例 3：
     * 输入：k = 3, n = 14
     * 输出：4
     */
    public int superEggDrop(int k, int n) {
        if (k == 1){
            return n;
        }
        if (n == 0){
            return 0;
        }

        int[][] dp = new int[k + 1][n + 1];

        int m = 0;
        while (dp[k][m] < n){
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int superEggDrop2(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n){
        if (!map.containsKey(n * 100 + k)){
            int ans;
            if (n == 0){
                ans = 0;
            }else if (k == 1){
                ans = n;
            }else {
                int l = 1, h = n;
                while (l + 1 < h){
                    int m = (l + h) / 2;
                    int broken = dp(k - 1, m - 1);
                    int not_broken = dp(k, n - m);
                    if (broken < not_broken){
                        l = m;
                    }else if (broken > not_broken){
                        h = m;
                    }else {
                        l = h = m;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(k - 1, l - 1), dp(k, n - l)), Math.max(dp(k - 1, h - 1), dp(k, n - h)));
            }
            map.put(n * 100 + k, ans);
        }
        return map.get(n * 100 + k);
    }
}
