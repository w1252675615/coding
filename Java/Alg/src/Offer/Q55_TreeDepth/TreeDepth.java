package Offer.Q55_TreeDepth;
/*
    求解二叉树的深度
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left+1:right+1;
    }
}
