package 专项4_BinaryTree.输出二叉树;

import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt_655 {
    /**
     * 655. 输出二叉树
     * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
     * 行数 m 应当等于给定二叉树的高度。
     * 列数 n 应当总是奇数。
     * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
     * 你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。
     * 即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。
     * 然而，如果两个子树都为空则不需要为它们留出任何空间。
     * 每个未使用的空间应包含一个空的字符串""。
     * 使用相同的规则输出子树。
     * 示例 1:
     * 输入:
     *      1
     *     /
     *    2
     * 输出:
     * [["", "1", ""],
     *  ["2", "", ""]]
     * 示例 2:
     * 输入:
     *      1
     *     / \
     *    2   3
     *     \
     *      4
     * 输出:
     * [["", "", "", "1", "", "", ""],
     *  ["", "2", "", "", "", "3", ""],
     *  ["", "", "4", "", "", "", ""]]
     * 示例 3:
     * 输入:
     *       1
     *      / \
     *     2   5
     *    /
     *   3
     *  /
     * 4
     * 输出:
     * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
     *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
     *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
     *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
     */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        int height = getHeight(root);
        String[][] ans = new String[height][(1 << height) -1];
        for (String[] arr : ans) {
            Arrays.fill(arr,"");
        }
        fill(ans, root, 0, 0, ans[0].length);
        for (String[] arr : ans) {
            res.add(Arrays.asList(arr));
        }
        return res;
    }
    public void fill(String[][] ans, TreeNode root, int i, int l, int r){
        if (root == null){
            return;
        }
        ans[i][(l + r) / 2] = "" + root.val;
        fill(ans, root.left, i + 1, l, (l + r) / 2);
        fill(ans, root.right, i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
