class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for (int x : nums) {
            total += x;
        }
        if ((total & 1L) == 1L) {
            return 0;
        }
        return nums.length - 1;
    }
}