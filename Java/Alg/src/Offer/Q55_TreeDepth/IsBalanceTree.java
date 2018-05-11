package Offer.Q55_TreeDepth;

public class IsBalanceTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return isBalance(root) != -1;
    }
    private int isBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if ((left = isBalance(root.left)) != -1 && (right = isBalance(root.right)) != -1) {
            int d = left - right;
            if (d <= 1 && d >= -1) {
                return 1 + (left > right ? left : right);
            }
        }
        return -1;
    }
}
