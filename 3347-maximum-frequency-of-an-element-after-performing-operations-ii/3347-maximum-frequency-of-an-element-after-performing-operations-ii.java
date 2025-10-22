// class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
//         int n = nums.length;

//         Map<Integer, Integer> map = new HashMap<>();
//         List<int[]> list = new ArrayList<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             list.add(new int[] { num - k, 1 });
//             list.add(new int[] { num + k + 1, -1 });
//         }

//         TreeSet<Integer> ts = new TreeSet<>();
//         for (int[] l : list) {
//             ts.add(l[0]);
//         }
//         for (int num : map.keySet()) {
//             ts.add(num);
//         }

//         // Sorting
//         Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

//         int idx = 0;
//         int cur = 0, max = 0;
//         for (int t : ts) {
//             while (idx < list.size() && list.get(idx)[0] <= t) {
//                 cur += list.get(idx)[1];
//                 idx++;
//             }

//             int val = map.getOrDefault(t, 0);
//             max = Math.max(max, val + Math.min(numOperations, cur - val));
//         }
//         return max;
//     }
// }
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int r = Math.min(numOperations, mf(nums, k));
        int start = 0;
        int end = 0;
        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            final int n = nums[i];
            if (i > 0 && n == nums[i - 1]) {
                freq++;
            } else {
                freq = 1;
            }
            final int min = n - k;
            final int max = n + k;
            while (nums[start] < min) {
                start++;
            }
            while (end < nums.length && nums[end] <= max) {
                end++;
            }
            r = Math.max(r, Math.min(freq + numOperations, end - start));
        }
        return r;
    }

    public int mf(int[] nums, int k) {
        int end = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            final int target = nums[i] + 2 * k;
            while (end < nums.length && nums[end] <= target) {
                end++;
            }
            r = Math.max(r, end - i);
        }
        return r;
    }
}