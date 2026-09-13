class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] len = new int[n + 1][n + 1];
        int[][] count = new int[n + 1][n + 1];
        for (int prev = 0; prev <= n; prev++) {
            count[n][prev] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int takeLen = -1;
                int takeCount = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    takeLen = 1 + len[i + 1][i + 1];
                    takeCount = count[i + 1][i + 1];
                }
                int notTakeLen = len[i + 1][prev + 1];
                int notTakeCount = count[i + 1][prev + 1];
                if (takeLen > notTakeLen) {
                    len[i][prev + 1] = takeLen;
                    count[i][prev + 1] = takeCount;
                } else if (takeLen < notTakeLen) {
                    len[i][prev + 1] = notTakeLen;
                    count[i][prev + 1] = notTakeCount;
                } else {
                    len[i][prev + 1] = takeLen;
                    count[i][prev + 1] = takeCount + notTakeCount;
                }
            }
        }
        return count[0][0];
    }
}