class Solution {
    public int maxJump(int[] stones) {
        int ans= stones[1] - stones[0];
        int n = stones.length;
        
        for(int i=2; i< n; i++){
            int possibility = (stones[i-1]-stones[i-2]) + stones[i] - stones[i-1];
            ans = Math.max(ans, possibility);
        }
        return ans;
    }
}