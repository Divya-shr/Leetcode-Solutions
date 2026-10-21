class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<Character, Integer> ma1 = new HashMap<>();
        Map<String, Integer> ma2 = new HashMap<>();

        for(int i=0; i<minSize; i++) {
            char c = s.charAt(i);
            int cnt1 = ma1.getOrDefault(c, 0) + 1;
            ma1.put(c, cnt1);
        }
        int ans = 0;
        String temp = s.substring(0, minSize);
        if(ma1.size() <= maxLetters) {
            ma2.put(temp, 1);
            ans = 1;
        }
        
        for(int i=minSize; i<n ; i++) {
            char c = s.charAt(i);
            char removeChar = s.charAt(i - minSize);
            int cnt1 = ma1.getOrDefault(c, 0) + 1;
            
            ma1.put(c, cnt1);
            if(ma1.get(removeChar) == 1) {
                ma1.remove(removeChar);
            } else {
                ma1.put(removeChar, ma1.get(removeChar) - 1);
            }
            

            if(ma1.size() <= maxLetters) {
                temp = s.substring(i - minSize + 1, i + 1);
                int cnt2 = ma2.getOrDefault(temp, 0) +1;
                ma2.put(temp, cnt2);
                ans = Math.max(ans, cnt2);
            }
        }
        return ans;
    }
}