package intermediate.class02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem01_SubvalueEqualK {
    /**
     * 给定一个数组arr， 求差值为k的去重数字对。
     */
    public static List<List<Integer>> allPair(int[] arr, int k){
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int cur:arr) {
            if (set.contains(cur + k)){
                res.add(Arrays.asList(cur, cur + k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = allPair(new int[]{3, 5, 2, 7, 0, 2}, 2);
        for (List<Integer> list:lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
