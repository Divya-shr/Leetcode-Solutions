class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1)
            return true;
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        int target = sum / k;
        if (nums[n - 1] > target)
            return false;
        return helper(new int[k], nums, k, n - 1, target);
    }

    boolean helper(int[] temp, int[] nums, int k, int start, int target) {
        if (start < 0) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (temp[i] + nums[start] <= target) {
                temp[i] += nums[start];
                if (helper(temp, nums, k, start - 1, target)) {
                    return true;
                }
                temp[i] -= nums[start];
                if (temp[i] == 0)
                    break;
            }
        }
        return false;
    }
}