package LeetCode.DP;

public class Q337_HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = coreRob(root);
        return Math.max(res[0],res[1]);
    }
    private int[] coreRob(TreeNode node) {
        if (node == null) return new int[2];
        int[] res = new int[2];
        int[] left = coreRob(node.left);
        int[] right = coreRob(node.right);
        res[0] = Math.max(left[0],left[1]) +  Math.max(right[0],right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}
