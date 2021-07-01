package advanced.class03;

public class Code02_Manacher {
    /**
     * Manacher算法解决的问题
     * 字符串str中， 最长回文子串的长度如何求解？
     * 如何做到时间复杂度O(N)完成？
     * Manacher算法的全部细节和实现讲解
     */

    public static  char[] manacherString(String str){
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);//manacher字符串
        int[] pArr = new int[charArr.length];//回文半径数组
        int R = -1;//回文右边界的再往右一个位置，最优的有效区是R-1位置
        int C = -1;//中心
        int max = Integer.MIN_VALUE;
        //每个位置都求一下回文半径
        for (int i = 0; i != charArr.length; i++) {
            //i至少的回文半径
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1){
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength("bb"));
    }
}
