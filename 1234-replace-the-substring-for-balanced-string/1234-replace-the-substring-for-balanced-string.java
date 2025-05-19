class Solution {
    public int balancedString(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        int ml=Integer.MAX_VALUE;;
        int[] count=new int[4];
        int cond=n/4;
        for(char c:s.toCharArray())
        {
            if(c=='Q') count[0]++;
            if(c=='W') count[1]++;
            if(c=='E') count[2]++;
            if(c=='R') count[3]++;

        }
        for(r=0;r<n;r++)
        {
            if (s.charAt(r) == 'Q') count[0]--;
            if (s.charAt(r) == 'W') count[1]--;
            if (s.charAt(r) == 'E') count[2]--;
            if (s.charAt(r) == 'R') count[3]--;
            while(l<n && count[0]<=cond && count[1] <= cond && count[2] <= cond && count[3] <= cond)
            {
                 if (s.charAt(l) == 'Q') count[0]++;
                if (s.charAt(l) == 'W') count[1]++;
                if (s.charAt(l) == 'E') count[2]++;
                if (s.charAt(l) == 'R') count[3]++;
                ml=Math.min(ml,r-l);
                l++;
            }

        }
        return ml+1;
    }
}