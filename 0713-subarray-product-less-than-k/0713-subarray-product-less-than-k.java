class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int prd= 1;
        int ans = 0;
        int l= 0,r=0;

        if(k==0) return 0;
         while(r<n){
            prd*=nums[r];
            while(l<=r && prd>=k){
                 prd/=nums[l];
                 l++;
            }
            ans+=(r-l+1);
            r++;
         }
         return ans;
    }
}