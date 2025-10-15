class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len=1,prev=0,ans=1;
        for(int i=1;i<nums.size();i++) {
            if(nums.get(i) > nums.get(i-1)) len++;
            else {
                ans = Math.max(ans, len/2);
                ans = Math.max(ans, Math.min(prev,len));
                prev = len;
                len = 1;
            }
        }
        ans = Math.max(ans, len/2);
        ans = Math.max(ans, Math.min(prev,len));
        return ans;
    }
}