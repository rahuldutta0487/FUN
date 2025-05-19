import java.util.*;

public class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        Integer[] sa = buildSuffixArray(s);
        int[] lcp = buildLCP(s, sa);

        int maxLen = 0, start = 0;
        for (int i = 1; i < n; i++) {
            if (lcp[i] > maxLen) {
                maxLen = lcp[i];
                start = sa[i];
            }
        }

        return s.substring(start, start + maxLen);
    }

    private Integer[] buildSuffixArray(String s) {
        int n = s.length();
        Integer[] sa = new Integer[n];
        final int[][] rankWrapper = new int[1][];
        int[] rank = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }
        rankWrapper[0] = rank;

        for (int k = 1; k < n; k <<= 1) {
            final int K = k;
            Arrays.sort(sa, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    if (rankWrapper[0][a] != rankWrapper[0][b])
                        return Integer.compare(rankWrapper[0][a], rankWrapper[0][b]);
                    int ra = (a + K < n) ? rankWrapper[0][a + K] : -1;
                    int rb = (b + K < n) ? rankWrapper[0][b + K] : -1;
                    return Integer.compare(ra, rb);
                }
            });

            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                tmp[sa[i]] = tmp[sa[i - 1]];
                if (rankWrapper[0][sa[i]] != rankWrapper[0][sa[i - 1]] ||
                    ((sa[i] + K < n ? rankWrapper[0][sa[i] + K] : -1) !=
                     (sa[i - 1] + K < n ? rankWrapper[0][sa[i - 1] + K] : -1))) {
                    tmp[sa[i]]++;
                }
            }

            rankWrapper[0] = tmp;
            tmp = new int[n]; // allocate new array to avoid overwriting
            if (rankWrapper[0][sa[n - 1]] == n - 1) break;
        }
        return sa;
    }

    private int[] buildLCP(String s, Integer[] sa) {
        int n = s.length();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[sa[i]] = i;

        int[] lcp = new int[n];
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) h++;
                lcp[rank[i]] = h;
                if (h > 0) h--;
            }
        }
        return lcp;
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "banana";
        System.out.println(sol.longestDupSubstring(s)); // Output: "ana"
    }
}