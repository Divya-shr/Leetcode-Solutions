class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!min.isEmpty() && nums[min.peekLast()] > nums[right]) min.pollLast();
            min.offer(right);

            while (!max.isEmpty() && nums[max.peekLast()] < nums[right]) max.pollLast();
            max.offer(right);

            while (nums[max.peek()]-nums[min.peek()] > limit) {
                left = (max.peek() < min.peek()) ? max.poll() + 1 : min.poll() + 1;
            }

            res = Math.max(res, right-left+1);
        }

        return res;
    }
}