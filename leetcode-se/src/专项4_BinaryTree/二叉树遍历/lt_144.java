package 专项4_BinaryTree.二叉树遍历;

import sun.reflect.generics.tree.Tree;
import 专项4_BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lt_144 {
    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     * 提示：
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *进阶：递归算法很简单，你可以通过迭代算法完成吗？
     */
    //递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    //非递归解法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

    //Morris遍历

    /**
     * Morris遍历
     *      一种遍历二叉树的方式， 并且时间复杂度O(N)， 额外空间复杂度O(1)
     *      通过利用原树中大量空闲指针的方式， 达到节省空间的目的
     *
     *      Morris遍历细节
     *      假设来到当前节点cur， 开始时cur来到头节点位置
     *      1） 如果cur没有左孩子， cur向右移动(cur = cur.right)
     *      2） 如果cur有左孩子， 找到左子树上最右的节点mostRight：
     *              a.如果mostRight的右指针指向空， 让其指向cur，
     *                  然后cur向左移动(cur = cur.left)
     *              b.如果mostRight的右指针指向cur， 让其指向null，
     *                  然后cur向右移动(cur = cur.right)
     *      3） cur为空时遍历停止
     *
     *      Morris遍历的实质
     *      建立一种机制， 对于没有左子树的节点只到达一次， 对于有左子树的节点会到达两次
     *      morris遍历时间复杂度的证明
     * @param root
     * @return
     */


    //先序遍历：只访问一次，直接打印，两次，第一次打印
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2. right != null){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }else {
                res.add(cur1.val);
            }
            cur1 = cur1.right;
        }
        return res;
    }
    public void morris(TreeNode head){
        if (head == null){
            return;
        }

        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;//cur2是cur1的左孩子
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                //cur2变成cur1左子树，最右的节点
                if (cur2.right == null){//这是第一次来到cur1
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{//cur2.right==cur1
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
    }
}
