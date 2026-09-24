class Solution {
    public int maxTurbulenceSize(int[] arr) {
        long n = arr.length;
        if (n == 1) return 1;
        
        int up = 1, down = 1, res = 1;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i-1]) {
                down = up + 1;
                up = 1;
            } else {
                up = down = 1;
            }
            
            res = Math.max(res, Math.max(up, down));
        }

        return res;
    }
}