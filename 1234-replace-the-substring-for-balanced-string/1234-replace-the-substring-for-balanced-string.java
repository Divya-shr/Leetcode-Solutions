import java.util.*;

class Solution {
    public int balancedString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('Q', 0);
        freq.put('W', 0);
        freq.put('E', 0);
        freq.put('R', 0);

        for (char c : s.toCharArray()) {
            freq.put(c, freq.get(c) + 1);
        }

        int target = s.length() / 4;
        int left = 0, minLen = s.length();

        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.get(rightChar) - 1);

            
            while (left < s.length() &&
                   freq.get('Q') <= target &&
                   freq.get('W') <= target &&
                   freq.get('E') <= target &&
                   freq.get('R') <= target) {

                minLen = Math.min(minLen, right - left + 1);

               
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) + 1);
                left++;
            }
        }

        return minLen;
    }
}