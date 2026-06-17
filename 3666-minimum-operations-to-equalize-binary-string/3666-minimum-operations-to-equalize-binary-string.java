// class Solution {
//     public int minOperations(String s, int k) {
//         int n = s.length();

//         TreeSet<Integer>[] ts = new TreeSet[2];
//         Arrays.setAll(ts, i -> new TreeSet<>());

//         for (int i = 0; i <= n; i++) {
//             ts[i % 2].add(i);
//         }

//         int cnt0 = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '0') {
//                 cnt0++;
//             }
//         }

//         ts[cnt0 % 2].remove(cnt0);

//         Deque<Integer> q = new ArrayDeque<>();
//         q.offer(cnt0);

//         int ans = 0;
//         while (!q.isEmpty()) {
//             for (int size = q.size(); size > 0; --size) {
//                 int cur = q.poll();
//                 if (cur == 0) {
//                     return ans;
//                 }

//                 int l = cur + k - 2 * Math.min(cur, k);
//                 int r = cur + k - 2 * Math.max(k - n + cur, 0);

//                 TreeSet<Integer> t = ts[l % 2];

//                 Integer next = t.ceiling(l);
//                 while (next != null && next <= r) {
//                     q.offer(next);
//                     t.remove(next);
//                     next = t.ceiling(l);
//                 }
//             }
//             ans++;
//         }

//         return -1;
//     }
// }

class Solution {
    public int minOperations(String s, int k) {
        int zero = 0;
        int len = s.length();

        for (int i = 0; i < len; i++)
            zero += ~s.charAt(i) & 1;

        if (zero == 0)
            return 0;

        if (len == k)
            return (zero == len ? 1 : -1);

        int base = len - k;

        int odd = Math.max(
            (zero + k - 1) / k,
            (len - zero + base - 1) / base
        );

        odd += ~odd & 1;

        int even = Math.max(
            (zero + k - 1) / k,
            (zero + base - 1) / base
        );

        even += even & 1;

        int res = Integer.MAX_VALUE;

        if ((k & 1) == (zero & 1))
            res = Math.min(res, odd);

        if ((~zero & 1) == 1)
            res = Math.min(res, even);

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}