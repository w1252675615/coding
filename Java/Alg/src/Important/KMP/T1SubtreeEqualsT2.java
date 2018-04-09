package Important.KMP;
/*
    给定二叉树的根节点t1和t2，判断t2的二叉树是否与t1的某个子树完全相同
 */
public class T1SubtreeEqualsT2 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static String serialTree(Node head) { //先序遍历序列化
        if(head == null) {
            return "#_";
        }
        String res = head.value+"_";
        res += serialTree(head.left);
        res += serialTree(head.right);
        return res;
    }
    public static int[] getNext(char[] patternArr) {
        if (patternArr.length == 1) return new int[] {-1};
        int[] nextArr = new int[patternArr.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < patternArr.length) {
            if (patternArr[pos-1] == patternArr[cn]) {
                nextArr[pos++] = ++cn;
            }else if (cn > 0) {
                cn = nextArr[cn];
            }else {
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }
    public static int getIndexOf(char[] charArr, char[] patternArr) {
        if (charArr == null || patternArr == null || patternArr.length < 1 || patternArr.length > charArr.length) return -1;
        int[] next = getNext(patternArr);
        int c = 0;
        int p = 0;
        while (c < charArr.length && p < patternArr.length) {
            if (charArr[c] == patternArr[p]) {
                ++c;
                ++p;
            }else if (p == 0){
                ++c;
            }else {
                p = next[p];
            }
        }
        return p == patternArr.length ? c-p : -1;
    }
    public static boolean isSubtree(Node t1,Node t2) {
        String str1 = serialTree(t1);
        String str2 = serialTree(t2);
        char[] charArr = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        return getIndexOf(charArr,pattern) != -1;
    }
    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));

    }

}
