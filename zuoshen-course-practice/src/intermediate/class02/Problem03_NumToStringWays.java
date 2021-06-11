package intermediate.class02;

public class Problem03_NumToStringWays {
    /**
     * 将给定的数转换为字符串， 原则如下： 1对应 a， 2对应b， …..26对应z， 例如12258
     * 可以转换为"abbeh", "aveh", "abyh", "lbeh" and "lyh"， 个数为5， 编写一个函
     * 数， 给出可以转换的不同字符串的个数
     */
    public static int convertWays(int num){
        if (num < 1){
            return 0;
        }

        return process(String.valueOf(num).toCharArray(), 0);
    }

    public static int process(char[] str, int index){
        if (index == str.length){
            return 1;
        }

        if (str[index] == '0'){
            return 0;
        }

        int res = process(str, index + 1);
        if (index == str.length - 1){
            return res;
        }

        if (((str[index] - '0') * 10 + (str[index + 1] - '0')) < 27){
            res += process(str, index + 2);
        }
        return res;
    }

    public static int dpways(int num){
        if (num < 1){
            return 0;
        }
        char[] chs = String.valueOf(num).toCharArray();
        int[] dp = new int[chs.length + 1];
        dp[chs.length] = 1;
        dp[chs.length - 1] = chs[chs.length - 1] == '0' ? 0 : 1;
        for (int i = chs.length - 2; i >= 0; i--) {
            if (chs[i] == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i + 1] + ((chs[i] - '0') * 10 + (chs[i + 1] - '0') < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int test = 111143311;
        System.out.println(convertWays(test));
        System.out.println(dpways(test));
    }
}
