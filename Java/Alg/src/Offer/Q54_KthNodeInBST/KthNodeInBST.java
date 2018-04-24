package Offer.Q54_KthNodeInBST;
/*
    找出二叉搜索树中第k小的数
 */
public class KthNodeInBST {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 1) return null;
        int[] count = {k};
        return coreKth(pRoot,count);

    }
    TreeNode coreKth(TreeNode p, int[] k) {
        TreeNode target = null;
        if (p.left != null) target = coreKth(p.left,k);
        if (target == null){
            if (k[0] == 1) target = p;
            --k[0];
        }
        if (target == null && p.right != null) target = coreKth(p.right,k);
        return target;
    }
}
