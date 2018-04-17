package Offer.Q37_SerializeBinaryTree;

import java.util.LinkedList;

public class SerializeBinaryTree {
    String Serialize(TreeNode root) {
        if (root == null) return "#_";
        StringBuilder res = new StringBuilder();
        res.append(root.val).append("_");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();

    }

    TreeNode Deserialize(String str) {
        String[] strArr = str.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : strArr) {
            queue.offer(s);
        }
        return coreDeserialize(queue);
    }
    TreeNode coreDeserialize(LinkedList<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode cur = new TreeNode(Integer.parseInt(s));
        cur.left = coreDeserialize(queue);
        cur.right = coreDeserialize(queue);
        return cur;
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
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        System.out.println(serializeBinaryTree.Serialize(r10));
    }
}
