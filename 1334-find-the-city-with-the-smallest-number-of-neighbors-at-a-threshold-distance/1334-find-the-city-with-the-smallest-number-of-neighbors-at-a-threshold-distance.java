class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int cost[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = 100000;
                if (i == j)
                    cost[i][j] = 0;
            }
        }

        for (int[] node : edges) {
            int u = node[0];
            int v = node[1];
            int wt = node[2];
            cost[u][v] = wt;
            cost[v][u] = wt;

        }

        for (int k = 0; k < n; k++) {
            for (int i= 0; i < n; i++) {
                for(int j =0;j< n ;j++){
                    cost[i][j]= Math.min(cost[i][k]+cost[k][j],cost[i][j]);
                }
            }
        }

         int count =Integer.MAX_VALUE;
         int city=-1;
        for(int i =0;i< n ;i++){
            int lc =0;
            for(int j =0;j< n ;j++){
                if(i!=j&&cost[i][j]<=distanceThreshold) lc++;
            }
            if(lc<=count){
                count = lc;
                city = i;
            }

        }
        return city ;

    }
}