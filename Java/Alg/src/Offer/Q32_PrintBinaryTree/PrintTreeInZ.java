package Offer.Q32_PrintBinaryTree;


import java.util.ArrayList;
import java.util.Stack;

public class PrintTreeInZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<Stack<TreeNode>> line = new ArrayList<>();
        ArrayList<Integer> templine = new ArrayList<>();
        TreeNode tempNode;
        line.add(new Stack<>());
        line.add(new Stack<>());
        int current = 0;
        int next = 1;
        line.get(current).push(pRoot);
        while (!line.get(current).isEmpty() || !line.get(next).isEmpty()) {
            tempNode = line.get(current).pop();
            templine.add(tempNode.val);
            if (current == 0) {
                if (tempNode.left != null) {
                    line.get(next).push(tempNode.left);
                }
                if (tempNode.right != null) {
                    line.get(next).push(tempNode.right);
                }
            }else {
                if (tempNode.right != null) {
                    line.get(next).push(tempNode.right);
                }
                if (tempNode.left != null) {
                    line.get(next).push(tempNode.left);
                }
            }
            if (line.get(current).isEmpty()) {
                current = 1 - current;
                next = 1 - next;
                result.add(templine);
                templine = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);


        pRoot.left = r2;
        pRoot.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r4.left = r8;
        r4.right = r9;
        PrintTreeInZ printTreeInZ = new PrintTreeInZ();
        ArrayList<ArrayList<Integer>> result = printTreeInZ.Print(pRoot);
    }
}
