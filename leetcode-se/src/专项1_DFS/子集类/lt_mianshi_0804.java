package 专项1_DFS.子集类;

import java.util.*;

public class lt_mianshi_0804 {
    /**
     * 面试题 08.04. 幂集
     * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     *  输入： nums = [1,2,3]
     *  输出：
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        Deque<Integer> record = new ArrayDeque<>();
        process(nums, 0, record, res);
        return new ArrayList<>(res);
    }

    public void process(int[] nums, int index, Deque<Integer> record, List<List<Integer>> res){
        res.add(new ArrayList<>(record));
        HashSet<Integer> isUsed = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!isUsed.contains(nums[i])){
                isUsed.add(nums[i]);
                record.addLast(nums[i]);
                process(nums, i + 1, record, res);
                record.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new lt_90().subsetsWithDup(new int[]{1,2,3});
        for (List<Integer> list :lists
        ) {
            for (Integer i :
                    list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
