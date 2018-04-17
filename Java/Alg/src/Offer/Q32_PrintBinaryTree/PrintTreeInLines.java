package Offer.Q32_PrintBinaryTree;
/*
    按行从左到右打印二叉树
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PrintTreeInLines {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayDeque<TreeNode> dequeTreeNode = new ArrayDeque<>();
        TreeNode tempNode;
        dequeTreeNode.offerLast(pRoot);
        int tempLine = 1;
        int nextLine = 0;
        if (pRoot == null) return result;
        while (!dequeTreeNode.isEmpty()) {
            tempNode = dequeTreeNode.pollLast();
            temp.add(tempNode.val);
            --tempLine;
            if(tempNode.left != null) {
                ++nextLine;
                dequeTreeNode.offerLast(tempNode.left);
            }
            if(tempNode.right != null) {
                ++nextLine;
                dequeTreeNode.offerLast(tempNode.right);
            }
            if (tempLine == 0) {
                result.add(temp);
                temp = new ArrayList<>();
                tempLine = nextLine;
                nextLine = 0;
            }
        }
        return result;
    }
}
