package Important.BinaryTree;

/*
    二叉树的先序遍历，递归和非递归
 */
public class PreOrderTraversal {
    public static void preOrderRecur(TreeNode head) { //递归
        if (head != null) {
            System.out.print(head.val+" ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }
    }




}
