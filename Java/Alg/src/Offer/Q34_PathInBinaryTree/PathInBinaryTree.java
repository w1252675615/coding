package Offer.Q34_PathInBinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PathInBinaryTree {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Integer> tempPath = new Stack<>();
        int tempSum = 0;
        coreFind(root,target,tempPath,tempSum,result);
        return result;
    }
    private void coreFind(TreeNode root, int target,Stack<Integer> tempPath, int tempSum, ArrayList<ArrayList<Integer>> result) {
        tempSum += root.val;
        tempPath.push(root.val);
        boolean isLeaf = (root.left == null) && (root.right == null);
        if (isLeaf && tempSum == target) {
            ArrayList<Integer> path = new ArrayList<>();
            for (Integer x : tempPath) {
                path.add(x);
            }
            result.add(path);
        }
        if (root.left != null) coreFind(root.left,target,tempPath,tempSum,result);
        if (root.right != null) coreFind(root.right,target,tempPath,tempSum,result);
        tempPath.pop();
    }
}
