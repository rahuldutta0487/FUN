class Solution {
    public int minCost(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int i[] : dp) Arrays.fill(i , -1);
        return fun(1 , nums , 0 , dp);

    }
    int fun(int ind , int[] nums , int prev , int[][] dp){

          if(ind >= nums.length) return 0;
        if(ind == nums.length) return nums[prev];
        // if(ind == nums.length-1) return nums[nums.length-1];
        if(ind == nums.length-1) return Math.max(nums[nums.length-1] , nums[prev]);
        if(ind == nums.length-2) {
            int ans =  Math.max(nums[ind] , Math.max(nums[prev] , nums[ind+1]));
            if(ans == nums[ind]){
                return ans+ Math.min(nums[prev] , nums[ind+1]);
            }
             if(ans == nums[prev]){
                return ans+ Math.min(nums[ind] , nums[ind+1]);
            }
             if(ans == nums[ind+1]){
                return ans + Math.min(nums[prev] , nums[ind]);
            }
        }

        if(dp[ind][prev]!=-1) return dp[ind][prev];

        int a = Math.max(nums[ind] , nums[ind+1]) + fun(ind+2 , nums , prev , dp);
        int b = Math.max(nums[ind+1] , nums[prev]) + fun(ind+2 , nums , ind , dp);
        int c = Math.max(nums[ind] , nums[prev]) + fun(ind+2 , nums ,  ind+1 , dp );
        return dp[ind][prev] = Math.min(a , Math.min(b , c));

    }
}