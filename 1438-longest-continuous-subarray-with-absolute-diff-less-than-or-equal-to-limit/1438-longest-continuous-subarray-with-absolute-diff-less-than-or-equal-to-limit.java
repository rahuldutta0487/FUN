class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();
        int left = 0, answer = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!increasing.isEmpty() && nums[right] < increasing.getLast()) {
                increasing.removeLast();
            }
            while (!decreasing.isEmpty() && nums[right] > decreasing.getLast()) {
                decreasing.removeLast();
            }
            increasing.addLast(nums[right]);
            decreasing.addLast(nums[right]);

            while (decreasing.getFirst() - increasing.getFirst() > limit) {
                if (nums[left] == increasing.getFirst()) {
                    increasing.removeFirst();
                }
                if (nums[left] == decreasing.getFirst()) {
                    decreasing.removeFirst();
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}