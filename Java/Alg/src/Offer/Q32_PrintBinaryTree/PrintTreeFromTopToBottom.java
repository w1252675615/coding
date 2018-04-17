package Offer.Q32_PrintBinaryTree;

/*
    按层打印二叉树，不用分行
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PrintTreeFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> dequeTreeNode =  new ArrayDeque<>();
        TreeNode printNode;
        dequeTreeNode.offerLast(root);
        while (!dequeTreeNode.isEmpty()) {
            printNode = dequeTreeNode.pollFirst();
            result.add(printNode.val);
            if (printNode.left != null) dequeTreeNode.offerLast(printNode.left);
            if (printNode.right != null) dequeTreeNode.offerLast(printNode.right);
        }
        return result;
    }
}
