package intermediate.class01;

public class Problem01_CordCoverMaxPoint {
    /**
     * 给定一个有序数组arr， 代表数轴上从左到右有n个点arr[0]、 arr[1]...arr[n－ 1]，
     * 给定一个正数L， 代表一根长度为L的绳子， 求绳子最多能覆盖其中的几个点。
     */
    public static int maxPoint(int[] arr, int L){
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] - L);
            int nearrest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearrest + 1);
        }
        return res;
    }
    //使用二分法找到绳子从某个点开始的节点
    public static int nearestIndex(int[] arr, int R, int value){
        int L = 0;
        int index = R;
        System.out.println(value);
        while (L < R){
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value){
                index = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 13, 24, 35, 46, 57, 60, 72, 87 };
        int L = 50;

        System.out.println(maxPoint(arr, L));

    }
}
