package bitOperation;

public class lt_1442 {
    /**
     * 1442. 形成两个异或相等数组的三元组数目
     * 给你一个整数数组 arr 。
     * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
     * a 和 b 定义如下：
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * 注意：^ 表示 按位异或 操作。
     * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] ^ arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (s[i] == s[k + 1]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] ^ arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (s[i] == s[k + 1]){
                    res += k - i;
                }
            }
        }
        return res;
    }
}
