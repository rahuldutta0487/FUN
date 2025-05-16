class Solution {
  public int palindromePartition(String s, int k) {
    if (s.length() == 1) {
      return 0;
    }

    if (s.length() == 2) {
      return k == 2 || s.charAt(0) == s.charAt(1) ? 0 : 1;
    }

    int[][][] dp = new int[s.length()][s.length()][k];

    // O(k*n*n)
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i; j < s.length(); j++) {
        int u = Math.min(j - i + 1, k);
        for (int l = 0; l < u; l++) {
          if (l == j - i) {
            dp[i][j][l] = 0;
          } else if (j - i == 1) {
            dp[i][j][l] = s.charAt(i) == s.charAt(j) ? 0 : 1;
          } else if (l == 0) {
            dp[i][j][l] = dp[i + 1][j - 1][0] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
          } else {
            int m = i;
            while (m <= j - l) {
              if (m == i) {
                dp[i][j][l] = dp[i][m][0] + dp[m + 1][j][l - 1];
                m++;
                continue;
              }

              dp[i][j][l] = Math.min(dp[i][j][l], dp[i][m][0] + dp[m + 1][j][l - 1]);
              if (dp[i][j][l] == 0) {
                break;
              }

              m++;
            }
          }
        }
      }
    }

    return dp[0][s.length() - 1][k - 1];
  }
}