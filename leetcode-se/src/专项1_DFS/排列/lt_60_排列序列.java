package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.List;

public class lt_60_排列序列 {
    /**
     * 60. 排列序列
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 示例 1：
     * 输入：n = 3, k = 3
     * 输出："213"
     * 示例 2：
     * 输入：n = 4, k = 9
     * 输出："2314"
     * 示例 3：
     * 输入：n = 3, k = 1
     * 输出："123"
     * 提示：
     *
     * 1 <= n <= 9
     * 1 <= k <= n!
     */
    boolean[] isUsed;
    int[] facs;
    int n, k;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        facs = new int[n + 1];
        facs[0] = 1;
        for (int i = 1; i <= n; i++) {
            facs[i] = facs[i - 1] * i;
        }

        isUsed = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        dfs(0, path);

        return path.toString();
    }

    public void dfs(int index, StringBuilder path){
        if (index == n){
            return;
        }

        int cnt = facs[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (isUsed[i]){
                continue;
            }

            if (cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            isUsed[i] = true;
            dfs(index + 1, path);
            return;
        }
    }

    public String getPermutation2(int n, int k) {
        k--;
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = fac[i - 1] * i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fac[i];
            res.append(nums.remove(index));
            k -= index * fac[i];
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String permutation = new lt_60_排列序列().getPermutation(4, 9);
        System.out.println(permutation);
    }


}
