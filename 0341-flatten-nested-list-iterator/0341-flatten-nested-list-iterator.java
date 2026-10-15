public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> q;
    public NestedIterator(List<NestedInteger> nestedList) {
        q=new LinkedList<Integer>();
        dfs(nestedList);
    }
    private void dfs(List<NestedInteger> nestedList){
        for(NestedInteger ni:nestedList)
            if(ni.isInteger()) q.add(ni.getInteger());
            else dfs(ni.getList());    
    }
    @Override
    public Integer next() {
        return q.poll(); 
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty(); 
    }
}