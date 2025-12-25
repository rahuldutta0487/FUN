class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long res = 0;
        for (int i = 0; i < k; i++) {
            int net = happiness[--n] - i;
            if (net <= 0) {
                break;
            }
            res += net;
        }
        return res;
    }
}