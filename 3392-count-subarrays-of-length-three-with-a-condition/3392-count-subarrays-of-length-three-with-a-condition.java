class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int sum = 0;
        for(int i = 1;i<n-1;i++){
            sum = nums[i-1]+nums[i+1];
            
            if(sum*2==nums[i]){
                
                cnt++;
            }
            
        }
        return cnt;
    }
}