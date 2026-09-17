class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < preorder.length()){
            int j = i;
            while(j < preorder.length() && preorder.charAt(j) != ','){
                j++;
            }
            String s = preorder.substring(i, j);
            if(!st.isEmpty()){
                while(!st.isEmpty() && s.equals("#") && st.peek().equals("#")){
                    st.pop();
                    if(st.isEmpty()) return false;
                    st.pop();
                }
            }
            st.push(s);
            i = j + 1;
        }

        if(st.size() == 1 && st.peek().equals("#")){
            return true;
        }
        return false;
    }
}