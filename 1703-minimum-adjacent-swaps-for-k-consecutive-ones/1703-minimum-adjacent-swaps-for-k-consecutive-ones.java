import java.util.*;

class Solution {

    // Idea 2 from Mr Guan: extract all indexes of 1s into List and do sliding window on that
    // every time we shift the window, we can update the cost of the window in constant time

    // Find best subArr with K 1s and merge it at median!!!

    //  ---->   <----
    // [1,0,0,1,0,0,1], k = 3   res = 4


    //  ---------->
    // [1,0,0,0,0,0,1,1], k = 3

    // [1,0,0,1,0,1,1,0,0,1,0,1]    k = 4
    //
    // [1,0,0,1,0,1,1] = 4
    //       [1,0,1,1,0,0,1] = 3
    //           [1,1,0,0,1,0,1] = 5

    // cost to append all 1s on left to index i:
    // leftCost[i] = sum(numOnesLeftOfEachZero[0] + ... numOnesLeftOfEachZero[i - 1])

    public int minMoves(int[] A, int k) {
        if (k == 1) return 0;
        int n = A.length;
        int best = Integer.MAX_VALUE;

        int[] rightCost = new int[n];
        int numRightOnes = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightCost[i] = rightCost[i + 1];
            if (A[i] == 0) rightCost[i] += numRightOnes;
            numRightOnes += A[i];
        }

        // media id = (k / 2) + (k % 2)
        Deque<Integer> medians = new ArrayDeque<>(k / 2 + 1);
        // 4 elems: 1,2,3,4  => median = 3
        // 3 elems: 1,2,3    => median = 2
        int offerMedianTh = k / 2;


        int[] leftCost = new int[n];
        int r = 0;
        int onesInside = 0;
        int numLeftOnes = 0;
        int numLeftOutside = 0;
        for (int l = 0; l < n; l++, onesInside--, numLeftOutside++) { // r = first outside
            while (r < n && onesInside < k) {
                if (A[r] == 1) {
                    onesInside++;
                    if (onesInside > offerMedianTh) medians.offer(r);
                }

                if (r > 0) leftCost[r] = leftCost[r - 1];
                if (A[r] == 0) leftCost[r] += numLeftOnes;
                numLeftOnes += A[r];
                r++;
            }
            if (onesInside < k) break;
            while (A[l] == 0) l++; // cut down left garbage

            int end = r - 1;
            int start = l;
            int medianId = medians.poll();

            int startToMed = leftCost[medianId] - leftCost[start];
            int endToMed = rightCost[medianId] - rightCost[end];


            int leftInside = k / 2;
            int rightInside = k - 1 - leftInside;

            // to subtract
            int leftMaxDist = medianId - start - leftInside;
            int rightMaxDist = end - medianId - rightInside;

            int numRightOutside = numRightOnes - numLeftOutside - onesInside; // total - leftOutside - inside

            int leftOutside = numLeftOutside * leftMaxDist;
            int rightOutside = numRightOutside * rightMaxDist;
            /////////////

            int left = startToMed - leftOutside;
            int right = endToMed - rightOutside;
            int currCost = left + right;
            best = Math.min(best, currCost);
        }


        return best;
    }

}