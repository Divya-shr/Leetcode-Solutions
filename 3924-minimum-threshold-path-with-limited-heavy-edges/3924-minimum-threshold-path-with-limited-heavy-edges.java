class Solution {

    List<int[]>[] adj;

    boolean bfs01(int n, int k, int src, int target, int mid) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);

        dist[src] = 0;
        dq.add(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int wt = (edge[1] > mid) ? 1 : 0;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;

                    if (wt == 0) dq.addFirst(v);
                    else dq.addLast(v);
                }
            }
        }

        return dist[target] <= k;
    }

    public int minimumThreshold(int n, int[][] edges,
                                int source, int target, int k) {

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        int left = 0, right = (int)1e9, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (bfs01(n, k, source, target, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}