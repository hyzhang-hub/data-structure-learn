package bitOperation;

public class lt_477 {
    /**
     * 477. 汉明距离总和
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     * 计算一个数组中，任意两个数之间汉明距离的总和。
     * 示例:
     * 输入: 4, 14, 2
     * 输出: 6
     * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     * 注意:
     * 数组中元素的范围为从 0到 10^9。
     * 数组的长度不超过 10^4。
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int num :
                    nums) {
                c += (num >>> i) & 1;
            }
            total += c * (n - c);
        }
        return total;
    }

    public int totalHammingDistance2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i){
                    total += hanmingDis(nums[i], nums[j]);

                }
            }
        }


        return total;
    }

    public int hanmingDis(int a, int b){
        return Integer.bitCount(a ^ b);
    }

    public static void main(String[] args) {
        int i = new lt_477().totalHammingDistance(new int[]{4, 14, 2});
        System.out.println(i);
    }

}
