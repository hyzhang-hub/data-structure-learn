package 专项11_DP.四鸡蛋或者其他物品掉落;

public class lt_1884 {
    /**
     *给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     *
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
     *
     * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
     * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     *
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
     * 如果第一枚鸡蛋碎了，可知 f = 0；
     * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
     * 否则，当两个鸡蛋都没碎时，可知 f = 2。
     * 示例 2：
     * 输入：n = 100
     * 输出：14
     *
     */
    public int twoEggDrop(int n) {
        if (n == 0){
            return 0;
        }
        int[][] dp = new int[3][n + 1];
        int m = 0;
        while (dp[2][m] < n){
            m++;
            for (int i = 1; i < 3; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
