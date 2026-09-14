class BrowserHistory {
    private class ListNode {
        private String page;
        private ListNode prev, next;

        public ListNode() {}

        public ListNode(String page) {this.page = page;} 

        public ListNode(String page, ListNode prev, ListNode next) {
            this.page = page;
            this.prev = prev;
            this.next = next;
        } 
    } 

    private ListNode head;
    private int fore, back;

    public BrowserHistory(String homepage) {
        this.head = new ListNode(homepage);
        this.fore = 0;
        this.back = 0;
    }
    
    public void visit(String url) {
        fore = 0;

        ListNode now = new ListNode(url);

        now.next = head;
        head.prev = now;
        head = now;

        back++;
    }
    
    public String back(int steps) {
        int x = Math.min(steps, back);

        fore += x;
        back -= x;

        int q = -1;

        while (++q < x) head = head.next;

        return head.page;
    }
    
    public String forward(int steps) {
        int x = Math.min(steps, fore); 

        fore -= x;
        back += x;

        int q = -1;

        while (++q < x) head = head.prev;

        return head.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */