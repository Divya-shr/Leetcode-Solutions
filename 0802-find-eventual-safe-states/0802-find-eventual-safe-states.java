import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // Step 1: Build the reversed adjacency list and compute InDegrees
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                // Original: u -> v | Reversed: v -> u
                revAdj.get(v).add(u);
            }
            // InDegree in reversed graph is the OutDegree in original graph
            inDegree[u] = graph[u].length;
        }

        // Step 2: Push all terminal nodes (InDegree = 0 in reversed graph)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process the queue
        boolean[] isSafe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            isSafe[node] = true;

            for (int neighbor : revAdj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Collect safe nodes in sorted order naturally
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}