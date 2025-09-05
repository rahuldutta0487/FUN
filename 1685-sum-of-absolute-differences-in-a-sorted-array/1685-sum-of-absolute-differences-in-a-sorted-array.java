class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++)
            totalSum += nums[i];

        int LSum = 0;
        int RSum = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++){    
            RSum = totalSum - LSum - nums[i];
            if(i > 0)
                res[i] += nums[i] * i - LSum; 
            if(i < nums.length-1)
                res[i] += RSum - nums[i] * (nums.length-i-1); 
            LSum += nums[i];
        }
        return res;
    }
}