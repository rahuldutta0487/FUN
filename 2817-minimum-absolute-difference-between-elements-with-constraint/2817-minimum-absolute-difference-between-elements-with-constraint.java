class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> res = new TreeSet<>();

        for(int i=x;i<nums.size();i++){
            res.add(nums.get(i-x));

            Integer floor = res.floor(nums.get(i));  //Largest_no <= nums[i]
            Integer ceil = res.ceiling(nums.get(i));  //Smallest_no >=nums[i]

            if(floor!=null){
                min = Math.min(min,Math.abs(nums.get(i)-floor));
            }
            if(ceil != null){
                min = Math.min(min,Math.abs(nums.get(i)-ceil));
            }
        }
        return min;
    }
}