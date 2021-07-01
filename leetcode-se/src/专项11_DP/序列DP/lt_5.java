package 专项11_DP.序列DP;

import com.sun.org.apache.bcel.internal.generic.FSUB;

public class lt_5 {
    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        //所有长度为1的子串都是回文子串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        //枚举子串长度
        for (int L = 2; L <= n; L++) {
            //枚举子串的左边界
            for (int i = 0; i < n; i++) {
                //求出子串的右边界
                int j = L + i - 1;
                //防止右边界越界
                if (j >= n){
                    break;
                }

                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //如果dp[i][j]是true，就表示子串s[i,L]是回文
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public  char[] manacherString(String str){
        char[] chs = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length ; i++) {
            res[i] = (i & 1) == 0 ? '#' : chs[index++];
        }
        return res;
    }

    public String maxLcpsLength(String s){
        if (s == null || s.length() <= 1){
            return s;
        }
        char[] chs = manacherString(s);//manacher字符串
        int[] pArr = new int[chs.length];//回文半径数组
        int R = -1;//回文半径右边界再往右的一个位置，最优的有效区是R - 1位置
        int C = -1;//中心
        int max = Integer.MIN_VALUE;
        int start = 0, maxLen = 0;
        //每个位置都求一下回文半径
        for (int i = 0; i != chs.length; i++) {
            //第一步直接取得可能的最短回文半径，如果i>R，最短的回文半径是1，反之，最短的回文半径可能是i对应的i'的回文半径或者i到R的距离
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //取得最小值后，开始从边界进行暴力匹配，匹配失败就退出
            while (i + pArr[i] < chs.length && i - pArr[i] > -1){
                if (chs[i + pArr[i]] == chs[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];//更新回文串的右边界
                C = i;//更新回文串的中心
            }
            if (pArr[i] - 1 > maxLen){
                start = (i - pArr[i] - 1) / 2 + 1;
                maxLen = pArr[i] - 1;
            }
        }
        System.out.println(start);
        System.out.println(maxLen);
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(new lt_5().maxLcpsLength("1"));
    }
}
