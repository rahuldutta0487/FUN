class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);  
        int n = events.length;
        int[] startDays = new int[n];
        for (int i = 0; i < n; ++i) {
            startDays[i] = events[i][0];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; ++i) {
            int[] curr = events[i - 1];
            int prevIndex = binarySearch(events, curr[0]);
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prevIndex + 1][j - 1] + curr[2]);
            }
        }

        return dp[n][k];
    }
    private int binarySearch(int[][] events, int startDay) {
        int low = 0, high = events.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][1] < startDay) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}