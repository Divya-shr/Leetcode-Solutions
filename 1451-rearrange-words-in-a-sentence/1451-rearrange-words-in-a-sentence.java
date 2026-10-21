class Solution {
    static class Word {
        int pos, len;
        String s;
        Word(int p, int l, String str) {
            pos = p; len = l; s = str;
        }
    }
    public String arrangeWords(String text) {
        text = text.substring(0,1).toLowerCase() + text.substring(1);
        String[] words = text.split(" ");
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(new Word(i+1, words[i].length(), words[i]));
        }
        Collections.sort(list, (a,b) -> {
            if (a.len == b.len) return a.pos - b.pos;
            return a.len - b.len;
        });
        StringBuilder ans = new StringBuilder();
        for (Word w : list) {
            ans.append(w.s).append(" ");
        }
        ans.deleteCharAt(ans.length()-1);
        ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));
        return ans.toString();
    }
}