class AuthenticationManager {
    private Map<String, Integer> map;
    private int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, timeToLive + currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            int v = map.get(tokenId);

            if (v > currentTime) {
                map.put(tokenId, timeToLive + currentTime);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;

        for (int v : map.values()) if (v > currentTime) cnt++;

        return cnt;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */