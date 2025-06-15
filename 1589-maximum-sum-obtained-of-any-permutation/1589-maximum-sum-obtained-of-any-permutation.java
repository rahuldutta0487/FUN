class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        // build a overlap map of requests, assign numbers to overlaps from high to low
        int mod = 1000000007;
        int[] overlap = new int[nums.length];
        // overlap count using sweep line algo
        for (int[] range : requests) {
            overlap[range[0]]++;
            if (range[1]+1 < nums.length) overlap[range[1]+1]--;
        }
        for (int i=1; i<overlap.length; i++) 
            overlap[i] += overlap[i-1];
        // sort overlap and nums, assign matching
        Arrays.sort(nums);
        Arrays.sort(overlap);
        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(overlap));
        long sum = 0;
        int idx = nums.length - 1;
        for (int i= overlap.length -1; i>=0; i--) {
            sum = sum % mod + ((long) overlap[i] * nums[idx--]) % mod;
        }
        return (int) (sum + mod) % mod;
    }
}