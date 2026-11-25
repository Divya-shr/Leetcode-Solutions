class MagicDictionary {

    public class Node{
        char ch;
        HashMap<Character,Node> child = new HashMap<>();
        boolean isTerminal;
    }
    Node root;
    public MagicDictionary() {
        Node nn = new Node();
        nn.ch = '*';
         root = nn;
    }

    public void buildDict(String[] dictionary) {
        for(String str : dictionary){
            insert(str);
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord,0,false,root);
    }

    public boolean dfs(String word, int idx, boolean changed, Node temp){
        if(idx == word.length()){
            return changed && temp.isTerminal;
        }

        char ch = word.charAt(idx);
        for(char c : temp.child.keySet()){
            if(c == ch){
                if(dfs(word,idx+1,changed,temp.child.get(c))){
                    return true;
                }
            }
            else{
                if(!changed){
                    if(dfs(word,idx+1,true,temp.child.get(c))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void insert(String word) {
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.child.containsKey(ch)){
                temp = temp.child.get(ch);
            }
            else{
                Node nn = new Node();
                nn.ch = ch;
                temp.child.put(ch,nn);
                temp = temp.child.get(ch);
            }
        }
        temp.isTerminal = true;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */