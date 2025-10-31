import java.util.*;

class Solution {
    public List<Integer> getSneakyNumbers(int[] nums) {
        int n = nums.length - 2; // original 0..n-1
        long S = (long)n * (n - 1) / 2L;
        long S2 = (long)n * (n - 1) * (2L * n - 1) / 6L;

        long sumA = 0L, sumsqA = 0L;
        for (int v : nums) {
            sumA += v;
            sumsqA += (long)v * v;
        }

        long s1 = sumA - S;        // x + y
        long s2 = sumsqA - S2;     // x^2 + y^2
        long xy = (s1 * s1 - s2) / 2L;

        long D = s1 * s1 - 4L * xy;
        if (D < 0) throw new IllegalArgumentException("No integer solution (D < 0)");
        long sd = (long)Math.sqrt(D);
        if (sd * sd != D) throw new IllegalArgumentException("Discriminant not perfect square");

        long x = (s1 + sd) / 2L;
        long y = s1 - x;
        return Arrays.asList((int)x, (int)y);
    }
}