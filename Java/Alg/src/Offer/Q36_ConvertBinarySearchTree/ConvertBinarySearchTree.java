package Offer.Q36_ConvertBinarySearchTree;

import java.util.Optional;

/*
    将二叉搜索树变为双向链表，不用额外节点
 */


public class ConvertBinarySearchTree {
    public class Box{
        TreeNode node;
        Box(TreeNode node) {
            this.node = node;
        }
        TreeNode getNode() {
            return node;
        }
        void setNode(TreeNode node){
            this.node = node;
        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Box result = new Box(null);
        Box lastNodeInList = new Box(null);
        coreConvert(pRootOfTree,result,lastNodeInList);
        return result.getNode();

    }
    private void coreConvert(TreeNode pRootOfTree,Box result,Box lastNodeInList) {
        if (pRootOfTree == null) return;
        coreConvert(pRootOfTree.left,result,lastNodeInList);
        if (lastNodeInList.getNode() == null) result.setNode(pRootOfTree);
        else{
            pRootOfTree.left = lastNodeInList.getNode();
            lastNodeInList.getNode().right = pRootOfTree;
        }
        lastNodeInList.setNode(pRootOfTree);
        coreConvert(pRootOfTree.right,result,lastNodeInList);
    }

    public static void main(String[] args) {
        TreeNode r4 = new TreeNode(4);
        TreeNode r6 = new TreeNode(6);
        TreeNode r8 = new TreeNode(8);
        TreeNode r10 = new TreeNode(10);
        TreeNode r12 = new TreeNode(12);
        TreeNode r14 = new TreeNode(14);
        TreeNode r16 = new TreeNode(16);
        r10.left = r6;
        r10.right = r14;
        r6.left = r4;
        r6.right = r8;
        r14.left = r12;
        r14.right = r16;
        ConvertBinarySearchTree convertBinarySearchTree = new ConvertBinarySearchTree();
        convertBinarySearchTree.Convert(r10);
    }
}
