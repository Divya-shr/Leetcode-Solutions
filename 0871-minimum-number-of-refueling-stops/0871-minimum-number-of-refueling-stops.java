class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long maxLimit = startFuel;
        int i = 0;
        int ans = 0;
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        while (true) {
            if (maxLimit >= target)
                return ans;
            while (i < n && stations[i][0] <= maxLimit) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                maxLimit += pq.poll();
            } else {
                return -1;
            }
            ans++;
        }
    }
}