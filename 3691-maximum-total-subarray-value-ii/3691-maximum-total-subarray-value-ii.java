import java.util.*;

class Solution {

    int[][] mx, mn;
    int[] lg;
    int[] nums;

    private long value(int l, int r) {
        int len = r - l + 1;
        int k = lg[len];

        int maxVal = Math.max(mx[k][l], mx[k][r - (1 << k) + 1]);
        int minVal = Math.min(mn[k][l], mn[k][r - (1 << k) + 1]);

        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int m = lg[n] + 1;

        mx = new int[m][n];
        mn = new int[m][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int j = 1; j < m; j++) {
            int len = 1 << j;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                mx[j][i] = Math.max(mx[j - 1][i], mx[j - 1][i + half]);
                mn[j][i] = Math.min(mn[j - 1][i], mn[j - 1][i + half]);
            }
        }

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{value(l, n - 1), l, n - 1});
        }

        long ans = 0;

        while (k-- > 0) {
            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            if (r > l) {
                pq.offer(new long[]{value(l, r - 1), l, r - 1});
            }
        }

        return ans;
    }
}