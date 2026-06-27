import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    
    private static class FenwickTree {
        long[] ft;
        int N;

        public FenwickTree(int size) {
            this.N = size;
            this.ft = new long[size + 1];
        }

        public void update(int idx, long delta) {
            for (; idx <= N; idx += idx & -idx) {
                ft[idx] += delta;
            }
        }

        public long query(int idx) {
            long sum = 0;
            for (; idx > 0; idx -= idx & -idx) {
                sum += ft[idx];
            }
            return sum;
        }
    }

    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        
        long[] cumDmg = new long[n + 1];
        for (int i = 0; i < n; i++) {
            cumDmg[i + 1] = cumDmg[i] + damage[i];
        }

        long[] vals = new long[2 * n + 1];
        System.arraycopy(cumDmg, 0, vals, 0, n + 1);
        for (int k = 0; k < n; k++) {
            vals[n + 1 + k] = cumDmg[k + 1] + requirement[k] - hp;
        }
        
        long[] uniqueSortedVals = Arrays.stream(vals).distinct().sorted().toArray();
        
        Map<Long, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < uniqueSortedVals.length; i++) {
            valToIdx.put(uniqueSortedVals[i], i + 1);
        }
        
        int compressedSize = uniqueSortedVals.length;
        FenwickTree bit = new FenwickTree(compressedSize);
        long ans = 0;

        for (int k = 0; k < n; k++) {
            int cIdx = valToIdx.get(cumDmg[k]);
            bit.update(cIdx, 1);
            
            long T = cumDmg[k + 1] + requirement[k] - hp;

            int searchIdx = Arrays.binarySearch(uniqueSortedVals, T);
            if (searchIdx < 0) {
                searchIdx = -searchIdx - 1;
            }
            
            long countLT = bit.query(searchIdx); 
            
            long totalElements = bit.query(compressedSize);
            
            long countGE = totalElements - countLT;
            
            ans += countGE;
        }

        return ans;
    }
}