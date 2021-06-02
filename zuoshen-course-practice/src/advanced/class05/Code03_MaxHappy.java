package advanced.class05;

import java.util.EnumMap;
import java.util.List;

public class Code03_MaxHappy {
    /**
     * 派对的最大快乐值
     * 员工信息的定义如下:
     * class Employee {
     * public int happy; // 这名员工可以带来的快乐值
     * List<Employee> subordinates; // 这名员工有哪些直接下级
     * }
     * 公司的每个员工都符合 Employee 类的描述。 整个公司的人员结构可以看作是一棵标准的、 没有环的
     * 多叉树。 树的头节点是公司唯一的老板。 除老板之外的每个员工都有唯一的直接上级。 叶节点是没有
     * 任何下属的基层员工(subordinates列表为空)， 除基层员工外， 每个员工都有一个或多个直接下级。
     * 这个公司现在要办party， 你可以决定哪些员工来， 哪些员工不来。 但是要遵循如下规则。
     * 1.如果某个员工来了， 那么这个员工的所有直接下级都不能来
     * 2.派对的整体快乐值是所有到场员工快乐值的累加
     * 3.你的目标是让派对的整体快乐值尽量大
     * 给定一棵多叉树的头节点boss， 请返回派对的最大快乐值。
     */
    public static class Employee{
        public int happy;//这名员工可以带来的快乐值
        List<Employee> nexts;//这名员工有哪些直接下级
    }

    public static class Info{
        public int laiMaxHappy;
        public int buMaxHappy;
        public Info(int lai, int bu){
            this.laiMaxHappy = lai;
            this.buMaxHappy = bu;
        }
    }

    public static int maxHappy(Employee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }

    public static Info process(Employee employee){
        if (employee.nexts.isEmpty()){//x是基层员工
            return new Info(employee.happy, 0);
        }

        int lai = employee.happy;//x来的情况下， 整棵树的最大收益
        int bu = 0;//x不来的情况下，整棵树的最大收益
        for (Employee next : employee.nexts){
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }

    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }





    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }
}
