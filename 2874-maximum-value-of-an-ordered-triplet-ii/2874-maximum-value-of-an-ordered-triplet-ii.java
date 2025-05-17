class Solution {
    public long maximumTripletValue(int[] nums) {
         long[]left=new long[nums.length];
        long[]right=new long[nums.length];
        long max=0;
        left[0]=nums[0];
        right[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            left[i]=Math.max(left[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],nums[i]);
        }
        for(int i=1;i<nums.length-1;i++){
            long x=(left[i-1]-nums[i])*right[i+1];
            max=Math.max(max,x);
        }
        return max;
    }
}