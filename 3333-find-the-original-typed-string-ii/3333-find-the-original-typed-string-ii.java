import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        List<Integer> groups = new ArrayList<>();
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                len++;
            } else {
                groups.add(len);
                len = 1;
            }
        }
        groups.add(len);

        long total = 1;
        for (int g : groups) {
            total = (total * g) % MOD;
        }

        if (groups.size() >= k) {
            return (int) total;
        }

        int[] dp = new int[k];
        int[] prefix = new int[k];
        dp[0] = 1;
        Arrays.fill(prefix, 1);

        for (int groupLen : groups) {
            int[] newDp = new int[k];
            for (int j = 1; j < k; j++) {
                newDp[j] = prefix[j - 1];
                if (j - groupLen - 1 >= 0) {
                    newDp[j] = (newDp[j] - prefix[j - groupLen - 1] + MOD) % MOD;
                }
            }

            int[] newPrefix = new int[k];
            newPrefix[0] = newDp[0];
            for (int j = 1; j < k; j++) {
                newPrefix[j] = (newPrefix[j - 1] + newDp[j]) % MOD;
            }

            dp = newDp;
            prefix = newPrefix;
        }

        return (int) ((total - prefix[k - 1] + MOD) % MOD);
    }
}