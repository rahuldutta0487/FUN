class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = Integer.toString(n);
        int len = num.length(), k = digits.length;

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = digits[i].charAt(0) - '0';
        }

        // Count all numbers with length less than len(n)
        int count = 0, powerK = k;
        for (int i = 1; i <= len - 1; i++) {
            count += powerK;
            powerK *= k;
        }

        // Add count of numbers with same length as n
        return count + solve(0, len, k, arr, num);
    }

    private int bsearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= x) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int solve(int idx, int len, int k, int[] arr, String num) {
        if (idx == len) return 1;
        int cd = num.charAt(idx) - '0';

        int x = bsearch(arr, cd);

        if (x == 0) return 0;
        if (x == k && arr[k - 1] != cd) return (int) Math.pow(k, len - idx);

        if (arr[x - 1] > cd - 1) x--;

        int res = x * (int) Math.pow(k, len - idx - 1);
        if (x < k && arr[x] == cd) {
            res += solve(idx + 1, len, k, arr, num);
        }

        return res;
    }
}