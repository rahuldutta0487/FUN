class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        int rem = s.length() % k;

        if (rem > 0){
            int l = k - rem;
            while (l > 0){
                sb.append(fill);
                l--;
            }
        }
        
        int n = sb.length();
        String[] res = new String[n/k];
        int j = 0;

        for (int i=0; i<n; i+=k){
            res[j++] = sb.substring(i, i+k);
        }
        return res;

    }
}