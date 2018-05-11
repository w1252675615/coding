package LeetCode.DP;
/*
    环形抢劫问题
 */
public class Q213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(coreRob(nums,0,nums.length-2),coreRob(nums,1,nums.length-1));

    }
    public int coreRob(int[] nums,int lo,int hi) {
        int n1 = nums[lo];
        int n2 = Math.max(nums[lo],nums[lo+1]);
        for (int i = lo+2; i <=hi; ++i) {
            int temp = n2;
            n2 = Math.max(n1+nums[i],n2);
            n1 = temp;
        }
        return Math.max(n1,n2);
    }
}
