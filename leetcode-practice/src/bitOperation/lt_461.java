package bitOperation;

public class lt_461 {
    /**
     * 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     * 输入: x = 1, y = 4
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0){
            return -1;
        }

        int z = x ^ y;
        int res = 0;
        while (z > 0){
            if ((z & 1) == 1){
                res++;
            }
            z = z >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new lt_461().hammingDistance(1, 4);
        System.out.println(i);
    }
}
