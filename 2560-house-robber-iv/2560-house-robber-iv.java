class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0, r = 1000000000;

        while(l < r){
            int mid = l + (r - l)/2;
            if(canSteal(mid, nums, k))
                r = mid;
            else
                l = mid + 1;
        }

        return r;
    }

    private boolean canSteal(int value, int[] nums, int k){
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= value){
                k--;
                i++;
            }
        }

        return k <= 0;
    }
}