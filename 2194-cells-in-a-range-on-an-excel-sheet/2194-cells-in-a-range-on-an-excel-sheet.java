class Solution {
    public List<String> cellsInRange(String str) {
        char[] s = str.toCharArray();
        List<String> result = new ArrayList<>();
        for (char c1 = s[0]; c1 <= s[3]; c1++) {
            for (char c2 = s[1]; c2 <= s[4]; c2++) {
                result.add("" + c1 + c2);
            }
        }
        return result;
    }
}