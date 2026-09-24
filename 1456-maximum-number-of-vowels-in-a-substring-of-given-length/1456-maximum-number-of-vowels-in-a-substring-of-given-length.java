class Solution {
    public int maxVowels(String s, int k) {
        int maxi;
        int count = 0;

        // build the first window of size k
        for (int l = 0; l < k; l++) {
            if (isVowel(s.charAt(l))) {
                count++;
            }
        }
        maxi = count;

        // slide the window across the rest of the string
        for (int h = k; h < s.length(); h++) {
            if (isVowel(s.charAt(h - k))) {   // char leaving the window
                count--;
            }
            if (isVowel(s.charAt(h))) {       // char entering the window
                count++;
            }
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}