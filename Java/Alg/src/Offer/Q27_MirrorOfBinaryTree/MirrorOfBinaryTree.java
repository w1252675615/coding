package Offer.Q27_MirrorOfBinaryTree;
/*
    给出一个二叉树的头结点，将它变为它的镜像
 */
public class MirrorOfBinaryTree {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
