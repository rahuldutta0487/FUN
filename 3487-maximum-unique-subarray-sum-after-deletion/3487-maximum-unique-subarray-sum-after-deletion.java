class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int sum=0;
        int s=Integer.MIN_VALUE;
        for(int i:nums)set.add(i);
        for(int i:set){
            if(i>0)sum+=i;
            else s=Math.max(s,i);
        }
        if(sum>0)return Math.max(sum,s);
        else return s;
    }
}