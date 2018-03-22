package offer.BinaryTree;

import java.util.HashMap;

public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i ++) {
            map.put(in[i],i);
        }
        return coreReConstructBinaryTree(pre,0, pre.length - 1, map,0, in.length - 1);
    }
    public TreeNode coreReConstructBinaryTree(int[] pre, int preStart, int preEnd, HashMap<Integer,Integer> map, int inStart, int inEnd) {
        if(preStart>preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int index = map.get(pre[preStart]);
        root.left = coreReConstructBinaryTree(pre,preStart+1,preStart+index-inStart,map,inStart,index-1);
        root.right = coreReConstructBinaryTree(pre,preStart+index-inStart+1,preEnd,map,index+1,inEnd);
        return root;
    }
}
