class Solution {
    public int countHillValley(int[] nums) {
        int ctn = 0;

        for(int i = 1, last = nums[0]; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                if( (last > nums[i] && nums[i] < nums[i + 1]) ||
                    (last < nums[i] && nums[i] > nums[i + 1]) ) 
                    ctn++;
                last = nums[i];
            }
        }

        return ctn;
    }
}