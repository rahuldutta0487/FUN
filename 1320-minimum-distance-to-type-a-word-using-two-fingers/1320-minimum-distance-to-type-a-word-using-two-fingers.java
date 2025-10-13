class Solution {
    public int minimumDistance(String word) {
        int[] keys = new int[word.length()];
        for (int i = 0; i < word.length(); i++) keys[i] = word.charAt(i) - 'A';

        int[][] cost = new int[27][26];
        for (int i = 0; i < 26; i++) {
            for (int j = i; j < 26; j++) {
                cost[i][j] = Math.abs(i/6 - j/6) + Math.abs(i%6 - j%6);
                cost[j][i] = cost[i][j];
            }
        }
        int[] dp = new int[27];
        
        for (int i = keys.length - 1; i > 0; i--) {
            int dp_for_key_at_i_minus_1 = dp[keys[i - 1]];
            int cost_i_minus_1_to_i = cost[keys[i - 1]][keys[i]];
            for (int j = 0; j < 27; j++) {
                dp[j] = Math.min(
                    dp_for_key_at_i_minus_1 + cost[j][keys[i]], 
                    dp[j] + cost_i_minus_1_to_i);
            }
        }
        return dp[26];
    }
}