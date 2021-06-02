package advanced.class03;

public class Code01_KMP {
    /**
     * KMP算法解决的问题
     * 字符串str1和str2， str1是否包含str2， 如果包含返回str2在str1中开始的位置。
     * 如何做到时间复杂度O(N)完成？
     *
     * KMP算法的全部细节和实现讲解
     */

    public static int getIndexOf(String s, String m){
        if (s == null || m == null || s.length() < m.length() || m.length() < 1){
            return -1;
        }
        char[] chs1 = s.toCharArray();
        char[] chs2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(chs2);
        while (i1 < chs1.length && i2 < chs2.length){
            if (chs1[i1] == chs2[i2]){
                i1++;
                i2++;
            }else if (next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == chs2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{-1};
        }

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//next数组的位置
        int cn = 0;
        while (i < next.length){
            if (ms[i - 1] == ms[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){//
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
