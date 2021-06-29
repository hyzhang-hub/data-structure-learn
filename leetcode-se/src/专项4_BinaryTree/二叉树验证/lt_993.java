package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

public class lt_993 {
    /**
     * 993. 二叉树的堂兄弟节点
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     * 示例 1：
     * 输入：root = [1,2,3,4], x = 4, y = 3
     * 输出：false
     * 示例 2：
     * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
     * 输出：true
     * 示例 3：
     * 输入：root = [1,2,3,null,4], x = 2, y = 3
     * 输出：false
     */
    int x;
    int xD;
    TreeNode xParent;
    boolean xFound;

    int y;
    int yD;
    TreeNode yParent;
    boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return this.xD == this.yD && this.xParent != this.yParent;
    }

    public void dfs(TreeNode node, int dept, TreeNode parent){
        if (node == null){
            return;
        }

        if (node.val == this.x){
            this.xParent = parent;
            this.xD = dept;
            xFound = true;
        }
        if (node.val == this.y){
            this.yParent = parent;
            this.yD = dept;
            yFound = true;
        }

        if (xFound && yFound){
            return;
        }

        dfs(node.left, dept + 1, node);
        dfs(node.right, dept + 1, node);
    }
}
