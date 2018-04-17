package Offer.Q26_SubstructureIntree;
/*
   判断一个二叉树是否是另一颗二叉树的子结构
*/

public class SubstructureIntree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = tree2IsSubstructureOfTree1(root1,root2);
            }
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    private boolean tree2IsSubstructureOfTree1(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return tree2IsSubstructureOfTree1(root1.left,root2.left) && tree2IsSubstructureOfTree1(root1.right,root2.right);
        }
        return false;
    }

}
