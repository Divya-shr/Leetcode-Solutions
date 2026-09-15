class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public void insert(TrieNode root, int i) {
        TrieNode curr = root;

        String s = String.format("%32s",Integer.toBinaryString(i)).replace(' ', '0');  // converts int to 32 bit binary string
        for (char c : s.toCharArray()) {
            int bit = c - '0';
            if (curr.child[bit] == null)
                curr.child[bit] = new TrieNode();
            curr = curr.child[bit];
        }
    }
    public int find(TrieNode root, int i) {
        TrieNode curr = root;
        String s = String.format("%32s",Integer.toBinaryString(i)).replace(' ', '0');    // converts int to 32 bit binary string
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int bit = c - '0';
            int opp = 1 - bit;
            if (curr.child[opp] != null) {
                sb.append('1');
                curr = curr.child[opp];            
            }
            else {
                sb.append('0');
                curr = curr.child[bit];
            }
        }
        int ans = 0;
        for (int j = 0; j < 32; j++)
            ans = ans * 2 + (sb.charAt(j) - '0');
        
        return ans;

    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for (int i : nums)
            insert(root, i);
        
        int ans = 0;

        for (int i : nums)
            ans = Math.max(ans, find(root, i));
        
        return ans;
    }
}