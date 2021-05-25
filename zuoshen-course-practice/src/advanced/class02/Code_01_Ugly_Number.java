package advanced.class02;

public class Code_01_Ugly_Number {
    public static boolean isUgly(int number){
        if (number <= 0){
            return false;
        }
        int[] fac = {2 , 3 , 5};
        for (int i = 0; i < fac.length; i++) {
            while (number % 2 == 0){
                number = number / fac[i];
            }
        }
        return number == 1 ? true : false;
    }

    public static int nthUglyNumber(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = Math.min(Math.min(2 * dp[i2], 3 * dp[i3]), 5 * dp[i5]);
            if (dp[i] == 2 * dp[i2]){
                i2++;
            }
            if (dp[i] == 3 * dp[i3]){
                i3++;
            }
            if (dp[i] == 5 * dp[i5]){
                i5++;
            }
        }
        return dp[n];
    }


}
