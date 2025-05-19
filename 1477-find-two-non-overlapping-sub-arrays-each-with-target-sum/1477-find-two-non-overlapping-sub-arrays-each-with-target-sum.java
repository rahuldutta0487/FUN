class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] shortest = new int[arr.length + 1];
        int min = Integer.MAX_VALUE;
        Arrays.fill(shortest, Integer.MAX_VALUE);
        int[] presum = new int[arr.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            presum[i + 1] = presum[i] + arr[i];
            if (map.containsKey(presum[i + 1] - target)) {
                int j = map.get(presum[i + 1] - target);
                int length = i - j;
                if (shortest[j + 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, shortest[j + 1] + length);
                }
                shortest[i + 1] = Math.min(shortest[i], length);
            } else {
                shortest[i + 1] = shortest[i];
            }
            map.put(presum[i + 1], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}