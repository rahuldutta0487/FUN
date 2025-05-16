import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final int MOD = 1_000_000_007;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < prevRoom.length; i++) {

            graph[prevRoom[i]].add(i);
        }

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = modInverse(fact[n]);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }


        return (int) dfs(graph, 0, fact, invFact)[0];
    }

    private long[] dfs(List<Integer>[] graph, int node, long[] fact, long[] invFact) {
        long ans = 1;
        int l = 0;
        for (int child : graph[node]) {
            long[] res = dfs(graph, child, fact, invFact);
            int r = (int) res[1];
            l = l + r;
            ans = (ans * res[0] % MOD * comb(l, r, fact, invFact)) % MOD;
        }
        return new long[]{ans, l + 1};
    }

    private long comb(int n, int r, long[] fact, long[] invFact) {
        if (n < r) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long modInverse(long x) {
        long res = 1;
        long y = MOD - 2;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % MOD;
            }
            y = y >> 1;
            x = (x * x) % MOD;
        }
        return res;
    }


}