class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        
        if (k == 1) 
            return new long[] { 1L * n * (n + 1) / 2 };
            
        long[] ans = new long[k];
        int[] prevCount = new int[k];
        int[] currCount = new int[k];

        for (int x : nums) {
            int r = x % k;
            Arrays.fill(currCount, 0);
            ans[r]++;
            
            for (int j = 0; j < k; j++) {
                if (prevCount[j] > 0) {
                    int prod = (j * r) % k;
                    currCount[prod] += prevCount[j];
                    ans[prod] += prevCount[j];
                }
            }
            
            currCount[r]++;
            System.arraycopy(currCount, 0, prevCount, 0, k);
        }
        
        return ans;
    }
}