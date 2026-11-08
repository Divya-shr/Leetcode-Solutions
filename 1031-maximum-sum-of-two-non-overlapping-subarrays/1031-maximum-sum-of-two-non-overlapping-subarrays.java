class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 1; i < n+1; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        int maxAns = Integer.MIN_VALUE;
        // firstLen first;
        int temp = -1;
        for (int i = n-secondLen; i >= firstLen; i--) {
            temp = Math.max(temp, pre[i + secondLen] - pre[i]);
            maxAns = Math.max(pre[i] - pre[i-firstLen] + temp, maxAns);
        }
        // secondLen first;
        temp = -1;
        for (int i = n-firstLen; i >= secondLen; i--) {
            temp = Math.max(temp, pre[i+firstLen] - pre[i]);
            maxAns = Math.max(pre[i] - pre[i-secondLen] + temp, maxAns);
        }
        return maxAns;
    }
}