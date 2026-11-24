class Solution {
    public int minSwaps(String s) {

        int n=s.length();
        int cnt0=0,cnt1=0;

        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c == '0') cnt0++;
            else cnt1++;
        }

        if(Math.abs(cnt0-cnt1) > 1) return -1;

        int cnt0violators=cntviolators(s,'0');
        int cnt1violators=cntviolators(s,'1');

        if(cnt0 == cnt1)
            return Math.min(cnt0violators,cnt1violators)/2;

        if(cnt0 > cnt1) return cnt0violators/2;
        else return cnt1violators/2;
    }

    int cntviolators(String s,char start)
    {
        int vio=0;
        char expec=start;
        for(char c : s.toCharArray())
        {
            if(c != expec) vio++;

            if(expec == '0') expec='1';
            else expec='0';
        }
        return vio;
    }
}