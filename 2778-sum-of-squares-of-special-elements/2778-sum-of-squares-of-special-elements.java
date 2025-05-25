class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int a=i+1;
            if(n%a == 0){
                int b=nums[i]*nums[i];
                count=count+b;
            }
        }
        return count;
    }
}