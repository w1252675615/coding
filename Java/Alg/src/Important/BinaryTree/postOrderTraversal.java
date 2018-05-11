package Important.BinaryTree;

import java.util.Stack;

/*
    二叉树的后序遍历，递归和非递归
 */
public class postOrderTraversal {
    public static void postOrderRecur(TreeNode head) { //递归
        if (head != null) {
            postOrderRecur(head.left);
            postOrderRecur(head.right);
            System.out.print(head.val+" ");
        }
    }
    public static void postOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        if (head == null) return;
        stack.push(head); // head表示最近弹出的节点
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
            }else if (cur.right != null && head != cur.right) {
                stack.push(cur.right);
            }else {
                System.out.print(stack.pop().val+" ");
                head = cur;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);

        pRoot.left = r2;
        pRoot.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.left = r8;
        r4.right = r9;
        postOrderRecur(pRoot);
        postOrder(pRoot);
    }
}
