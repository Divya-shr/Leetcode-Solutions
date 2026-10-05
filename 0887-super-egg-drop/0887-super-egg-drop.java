class Solution {
    int[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int[k+1][n+1];
        for(int[] dpin : dp) Arrays.fill(dpin,-1);

        return eggDrop(k,n);
    }

    public int eggDrop(int k, int n){
        // For 1floor 1 move is needed, for no/zero floor 0-moves
        if(n==0 || n==1) return n;

        // if there is only egg we can't take risk to break it so have to do linear search
        if(k==1) return n;

        if(dp[k][n]!=-1) return dp[k][n];

        int ans = n,i=1,nn = n;
        // ans is minimum moves needed for n floors with k eggs
        // using binary search in range (1,n) but can't use n as modifying can change value

        while(i<=nn){
            int mid = i + (nn-i)/2;

            int broke = eggDrop(k-1,mid-1);
            // here we have original n not temp nn 
            int noBroke = eggDrop(k,n-mid);

            if(broke>noBroke) nn = mid-1;
            else i = mid+1;

            ans = Math.min(ans,Math.max(broke,noBroke) + 1);
        }
        return dp[k][n] = ans;
    }
}
// 0 1 2 3 4 5 6 
// 3 - break                 | no-break
// 1 - break | nobreak       | 5- break    | nobreak
// 0 answer  | 2-tick        | 4 answer    | 6-answer