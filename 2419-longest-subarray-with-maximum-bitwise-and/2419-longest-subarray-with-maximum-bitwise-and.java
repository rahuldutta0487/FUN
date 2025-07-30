class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int size = 0, ans = 0;
        for (int num : nums) {
            if (num == maxVal) {
                size++;
                ans = Math.max(ans, size);
            } else {
                size = 0;
            }
        }
        return ans;
    }
}