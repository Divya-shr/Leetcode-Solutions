class OrderedStream {
    private Map<Integer, String> buffer;
    private int currentPointer;
    public OrderedStream(int n) {
        currentPointer = 1;
        buffer = new HashMap<>();
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> values = new ArrayList<>();
        if (idKey == currentPointer) {
            values.add(value);
            while (buffer.containsKey(++currentPointer))
                values.add(buffer.remove(currentPointer));
        } else
            buffer.put(idKey, value);
        return values;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */