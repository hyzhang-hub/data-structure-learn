package advanced.class07;

public class Code01_RobotWalk {
    public static int walkWays1(int N, int E, int S, int K){
        return  f1(N, E, K, S);
    }

    /**
     * 一共是1~N这么多位置  固定的参数
     * 最终的目标位置是E 固定的参数
     * 还剩rest步需要走
     * 当前在cur位置
     * 返回方法数
     * @param N
     * @param E
     * @param rest
     * @param cur
     * @return
     */
    public static int f1(int N, int E, int rest, int cur){
        if (rest == 0){
            return cur == E ? 1 : 0;
        }
        //rest > 0 有路可以走
        if (cur == 1){
            return f1(N, E, rest - 1, 2);
        }
        if (cur == N){
            return f1(N, E, rest - 1, N - 1);
        }
        return f1(N, E, rest - 1, cur - 1) + f1(N, E, rest - 1, cur + 1);
    }

    public static int walkWays2(int N, int E, int S, int K){
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return  f2(N, E, K, S, dp);
    }

    public static int f2(int N, int E, int rest, int cur, int[][] dp){
        if (dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        if (rest == 0){
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        //rest > 0 有路可以走
        if (cur == 1){
            dp[rest][cur] = f2(N, E, rest - 1, 2, dp);
        }else if (cur == N){
            dp[rest][cur] = f2(N, E, rest - 1, N - 1, dp);
        }else{
            dp[rest][cur] = f2(N, E, rest - 1, cur - 1, dp) + f2(N, E, rest - 1, cur + 1, dp);
        }
        return dp[rest][cur];
    }

    public static int walkWays3(int N, int E, int S, int K){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(walkWays1(7, 4, 9, 5));
        System.out.println(walkWays2(7, 4, 9, 5));
        System.out.println(walkWays3(7, 4, 9, 5));
    }


}
