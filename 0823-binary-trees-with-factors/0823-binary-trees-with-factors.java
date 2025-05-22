class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);
        
        long trees = 0;
        long mod = (long)1e9+7;
        long []dp = new long[n];
        
        for( int i=0; i<n; i++ ){
            long curr = 1;
            int lo = 0;
            int hi = i-1;
            while( lo <= hi ){      
                long prod = arr[lo] * arr[hi];
                if( prod == ( arr[i] % mod ) && arr[lo] <= ( arr[i]/2 ) && arr[hi] <= ( arr[i]/2 ) ){
                    int diff = 2;
                    if( arr[lo] == arr[hi] ) diff = 1;
                    curr = ( curr +  ( ( ( dp[hi] * dp[lo] ) % mod ) * diff ) % mod ) % mod;
                    lo++;
                    hi--;
                }
                else if ( prod > arr[i] ) hi--;
                else lo++;
            }
            dp[i] = curr;
            trees = ( trees + curr )%mod;
        }
        
        return (int)trees;
    }
}