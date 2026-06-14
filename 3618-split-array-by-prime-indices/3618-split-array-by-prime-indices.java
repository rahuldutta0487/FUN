class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long a1 = 0, a2 = 0;
        boolean[] vis = new boolean[n];
        // sieve
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) 
                vis[j] = true;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1 || vis[i])   a1 += nums[i];
            else a2 += nums[i];
        }
        return Math.abs(a1 - a2);
    }
}