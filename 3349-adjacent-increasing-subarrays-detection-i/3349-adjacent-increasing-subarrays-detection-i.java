class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            int[] arr1 = new int[k];
            int[] arr2 = new int[k];
            int index = 0;
            for (int j = 0; j < k; j++) {
                arr1[index] = nums.get(i + j);
                arr2[index] = nums.get(i + j + k);
                index++;
            }
            boolean arr1StrictlyIncreasing = true;
            for (int j = 1; j < k; j++) {
                if (arr1[j] <= arr1[j - 1]) {
                    arr1StrictlyIncreasing = false;
                    break;
                }
            }
            boolean arr2StrictlyIncreasing = true;
            for (int j = 1; j < k; j++) {
                if (arr2[j] <= arr2[j - 1]) {
                    arr2StrictlyIncreasing = false;
                    break;
                }
            }
            if (arr1StrictlyIncreasing && arr2StrictlyIncreasing) {
                return true;
            }
        }
        return false;
    }
}