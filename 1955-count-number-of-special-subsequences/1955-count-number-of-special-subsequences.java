class Solution {
    private final int MOD = 1000000007;

    public int countSpecialSubsequences(int[] nums) {
        long z = 0, zo = 0, zot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                z = (1 + (2 * z)) % MOD;
            else if (nums[i] == 1)
                zo = (z + (2 * zo)) % MOD;
            else
                zot = (zo + (2 * zot)) % MOD;
        }
        return (int) zot;
    }

}