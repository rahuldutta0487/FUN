import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> tillnow = new HashMap<>();

        // Count frequency of each element
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        // Iterate to find the split index
        for (int i = 1; i <= n; i++) {
            int a = nums.get(i - 1);
            tillnow.put(a, tillnow.getOrDefault(a, 0) + 1);

            // Check if 'a' is dominant in the first half
            if (tillnow.get(a) * 2 > i) {
                int dl = a;
                // Check if 'dl' is dominant in the second half
                if ((map.get(a) - tillnow.get(a)) * 2 > (n - i))
                    return i - 1;
            }
        }
        return -1;
    }
}