class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;
        int maxLen = n - (numFriends - 1);

        char maxChar = 'a';
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) > maxChar) {
                maxChar = word.charAt(i);
            }
        }

        int best = -1;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == maxChar) {
                if (best == -1) {
                    best = i;
                } else {
                    int x = best, y = i;
                    while (x < n && y < n && word.charAt(x) == word.charAt(y)) {
                        x++;
                        y++;
                    }
                    if (x == n) {
                        // best suffix ended, i is longer
                        best = i;
                    } else if (y < n && word.charAt(y) > word.charAt(x)) {
                        best = i;
                    }
                }
            }
        }

        int take = Math.min(maxLen, n - best);
        return word.substring(best, best + take);
    }
}