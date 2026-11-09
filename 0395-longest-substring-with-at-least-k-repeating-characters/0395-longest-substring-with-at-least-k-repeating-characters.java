class Solution {
    public int longestSubstring(String s, int k) {
        
        int max = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            int countNotEligible = 0;
            boolean[] b = new boolean[26];
            for(int j=i;j<n;j++)
            {
                char c =  s.charAt(j);
                map.put(c,map.getOrDefault(c,0)+1);
                int freq = map.get(c);
                if(freq<k && !b[c-'a']){
                    countNotEligible++;
                    b[c-'a'] = true;
                }
                else if(freq==k){
                    countNotEligible--;
                    b[c-'a'] = false;
                }

                if(countNotEligible<=0){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}