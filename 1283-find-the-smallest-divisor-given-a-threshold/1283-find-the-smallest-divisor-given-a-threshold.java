class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);

        while (low < high) {
            int div = (low + high) / 2;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + div - 1) / div;
            }

            if (sum > threshold) {
                low = div + 1;
            } else {
                high = div;
            }
        }

        return low;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}