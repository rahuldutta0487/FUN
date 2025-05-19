class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int start = 0, end = 0, sum = 0, max = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while(end < nums.length){
            
            if(set.add(nums[end])){
			// if we don't have any duplicate item in our set
                sum += nums[end];
                end++;
            }
            else{
			//remove and substract elements from starting until the duplicate element got removed.
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
            }
			//keeping track of the maximum sum of the subarray we got till now
            max = Math.max(sum, max);
        }
        
        return max;
    }
}