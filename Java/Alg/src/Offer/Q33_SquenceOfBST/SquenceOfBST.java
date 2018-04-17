package Offer.Q33_SquenceOfBST;

public class SquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return coreVerify(sequence,0,sequence.length-1);
    }
    private boolean coreVerify(int[] sequence, int start,int end) {
        int root = sequence[end];
        int i = start;
        for (;i < end;++i) {
            if (sequence[i] > root) break;
        }
        int j = i;
        for (;j < end;++j) {
            if (sequence[j] < root) return false;
        }
        boolean left = true;
        if (i > start) left = coreVerify(sequence,start,i-1);
        boolean right = true;
        if (i < end) right = coreVerify(sequence,i,end-1);
        return left && right;
    }
}
