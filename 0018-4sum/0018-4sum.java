class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            for(int j = i+1 ;j<nums.length-2;j++){
                long s = (long)target - nums[i] - nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    
                    if(nums[left] + nums[right] == s){
                        List<Integer> finalList = new ArrayList<>();
                        finalList.add(nums[left]);
                        finalList.add(nums[right]);
                        finalList.add(nums[i]);
                        finalList.add(nums[j]);
                        left++;
                        right--;
                        result.add(finalList);
                    }else if(nums[left] + nums[right] < s){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}