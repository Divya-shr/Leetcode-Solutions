class Solution {
    public int mod = (int)(1e9)+7;
    public Integer[][][] dp;
    public int countStableSubsequences(int[] nums) {
        dp = new Integer[nums.length][3][3];
        return f(0,nums,0,0)-1;
    }
    public int f(int idx,int[] nums,int cur_e,int cur_o){
        if(idx==nums.length) return 1;
        if(dp[idx][cur_e][cur_o]!=null) return dp[idx][cur_e][cur_o];
        int odd = 0;
        int even = 0;
        int notTake = 0;
        if(nums[idx]%2==1) odd = (odd+((cur_o<2)?f(idx+1,nums,0,cur_o+1):0))%mod;
        else even = (even+((cur_e<2)?f(idx+1,nums,cur_e+1,0):0))%mod;
        notTake = (notTake+f(idx+1,nums,cur_e,cur_o))%mod;
        return dp[idx][cur_e][cur_o] = ((odd+even)%mod+notTake)%mod;
    }
}