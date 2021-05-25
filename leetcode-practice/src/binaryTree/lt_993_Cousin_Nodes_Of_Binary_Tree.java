package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class lt_993_Cousin_Nodes_Of_Binary_Tree {

    /**
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    int x;
    TreeNode xParent;
    int xD;
    boolean xFound = false;

    int y;
    TreeNode yParent;
    int yD;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return this.xD == this.yD && this.xParent != yParent;
    }

    public void dfs(TreeNode node, int depth, TreeNode parent){
        if (node == null){
            return;
        }

        if (node.val == this.x){
            this.xParent = parent;
            this.xD = depth;
            this.xFound = true;
        }else if (node.val == this.y){
            this.yParent = parent;
            this.yD = depth;
            this.yFound = true;
        }
        if (xFound && yFound){
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound){
            return;
        }

        dfs(node.right, depth + 1, node);

    }

    public boolean isCousins2(TreeNode root, int x, int y) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> deptQueue = new LinkedList<>();
        nodeQueue.offer(root);
        update(root, 0, null);
        deptQueue.offer(0);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int depth = deptQueue.poll();
            if (node.left != null){
                nodeQueue.offer(node.left);
                deptQueue.offer(depth + 1);
                update(node.left, depth + 1, node);
            }
            if (node.right != null){
                nodeQueue.offer(node.right);
                deptQueue.offer(depth + 1);
                update(node.right, depth + 1, node);
            }
            if (this.xFound && this.yFound){
                break;
            }

        }
        return this.xD == this.yD && this.xParent != this.yParent;
    }

    public void update(TreeNode node, int depth, TreeNode parent){
        if (node.val == this.x){
            this.xParent = parent;
            this.xD = depth;
            this.xFound = true;
        }else if (node.val == this.y){
            this.yParent = parent;
            this.yD = depth;
            this.yFound = true;
        }
    }


}
