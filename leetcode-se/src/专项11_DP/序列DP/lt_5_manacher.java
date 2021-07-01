package 专项11_DP.序列DP;

public class lt_5_manacher {
    public char[] manacherStr(String s){
        char[] chs = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chs[index++];
        }
        return res;
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }

        char[] chs = manacherStr(s);
        int[] pArr = new int[chs.length];
        int R = -1;
        int C = -1;
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < chs.length; i++) {
            pArr[i] = R > i ? pArr[2 * C - i] : 1;
            while (i + pArr[i] < chs.length && i - pArr[i] > -1){
                if (chs[i + pArr[i]] == chs[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > maxLen){
                start = (i - pArr[i] - 1) / 2 + 1;
                maxLen = pArr[i] - 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
