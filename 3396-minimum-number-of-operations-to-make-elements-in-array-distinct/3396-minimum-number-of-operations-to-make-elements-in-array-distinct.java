class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        int r = 0 ; 

        while(r < nums.length){
            if(isUnique(r , nums)) {
                break ;
            }

            cnt++;
            r += 3;
        }

        return cnt ; 
    }

    public boolean isUnique(int r, int[] nums){
          Set<Integer> set = new HashSet<>();
        for(int i=r ; i <nums.length ; i++) {
            if(set.contains(nums[i])) {
                return false;
            }

            set.add(nums[i]);
        }

        return true;
    }
}