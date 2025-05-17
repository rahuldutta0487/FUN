class Solution {
    public int maximumCount(int[] nums) {
        int countpos=0;
        int countneg = 0;
        int maxi=Integer.MIN_VALUE;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]>0){
                countpos++;
            }
            if(nums[i]<0){
                countneg++;
            }
        }
        maxi = Math.max(maxi,countpos);
        maxi = Math.max(maxi,countneg);
        return maxi;
    }
}