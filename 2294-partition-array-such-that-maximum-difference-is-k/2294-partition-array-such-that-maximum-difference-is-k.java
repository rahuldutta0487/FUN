class Solution {
    public int partitionArray(int[] nums, int k) {
        Set<Integer> unique = new TreeSet<>();
        for (int num : nums) unique.add(num);
        Integer[] arr = unique.toArray(new Integer[0]);

        int ans = 1;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > k) {
                ans++;
                min = arr[i];
            }
        }
        return ans;
    }
}