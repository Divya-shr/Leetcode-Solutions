class Solution {
    public int[][] sortTheStudents(int[][] score, int k){

        Arrays.sort(score,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return Integer.compare(b[k],a[k]);
            }
        });
        return score;
    }
}