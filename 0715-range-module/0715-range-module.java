class RangeModule {

    private TreeMap<Integer, Integer> treeMap;

    public RangeModule() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int start = left, end = right;
        Map.Entry<Integer, Integer> entry;
        while ((entry = treeMap.floorEntry(end)) != null) {
            if (entry.getValue() < start) break;
            start = Math.min(start, entry.getKey());
            end = Math.max(end, entry.getValue());
            treeMap.remove(entry.getKey());
        }
        treeMap.put(start, end);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right);
        return entry != null && entry.getKey() <= left && entry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        int start = left, end = right;
        Map.Entry<Integer, Integer> entry;
        while ((entry = treeMap.lowerEntry(end)) != null) {
            if (entry.getValue() < start) break;
            treeMap.remove(entry.getKey());
            if (entry.getKey() < start) treeMap.put(entry.getKey(), start);
            if (entry.getValue() > end) treeMap.put(end, entry.getValue());
            end = entry.getKey();
            if (end <= start) break;
        }
    }
}