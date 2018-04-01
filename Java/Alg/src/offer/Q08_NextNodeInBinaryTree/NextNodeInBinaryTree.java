package offer.Q08_NextNodeInBinaryTree;
/*
        给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 */
public class NextNodeInBinaryTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode nextNode = null;
        if (pNode.right != null) {
            TreeLinkNode rightNode = pNode.right;
            while (rightNode.left != null) {rightNode = rightNode.left;}
            nextNode = rightNode;
        }else if(pNode.next != null) {
            TreeLinkNode currentNode = pNode;
            TreeLinkNode parentNode = pNode.next;
            while (parentNode != null && parentNode.left != currentNode){
                currentNode = parentNode;
                parentNode = parentNode.next;
            }
            nextNode = parentNode;
        }
        return nextNode;
    }
}
