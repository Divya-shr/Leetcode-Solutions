class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null) {
            list.add(curr.val);

            curr = curr.next;
        }

        int a[] = new int[list.size()];

        for(int i = 0; i < list.size() - 1; i++) {

            int max = list.get(i);

            for(int j = i+1; j < list.size(); j++) {

                if(max < list.get(j)) {
                    max = list.get(j);
                    break;
                }
            }

            if(max == list.get(i)){
                a[i] = 0;
            }
            else{
                a[i] = max;
            }
        }
        return a;
    }
}