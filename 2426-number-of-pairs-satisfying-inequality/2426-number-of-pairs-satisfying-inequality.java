
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        long count = 0;

        // Transform the array based on the given condition
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = nums1[i] - nums2[i];
        }

        return countPairs(transformed, 0, n - 1, diff);

    }

    public long countPairs(int[] arr, int l, int r, int diff) {
        if (l >= r)
            return 0; // Base case for recursion

        int mid = l + (r - l) / 2;

        // Recursively count pairs in the left and right halves
        long res = countPairs(arr, l, mid, diff) + countPairs(arr, mid + 1, r, diff);

        // Merge step: Count valid pairs across the two halves
        int[] left = Arrays.copyOfRange(arr, l, mid + 1); // inclusive on both sides
        int[] right = Arrays.copyOfRange(arr, mid + 1, r + 1); // inclusive on both sides

        Arrays.sort(left);
        Arrays.sort(right);

        // Use binary search for each element in the right array
        for (int value : right) {
            res += findValidCount(left, value + diff);
        }

        return res;
    }

    private int findValidCount(int[] arr, int target) {
        int l = 0, r = arr.length;

        // Standard binary search: Find the first element > target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1; // Move right if arr[mid] is valid
            } else {
                r = mid; // Move left to find the first invalid element
            }
        }

        // All elements before `l` are valid
        return l;
    }

}