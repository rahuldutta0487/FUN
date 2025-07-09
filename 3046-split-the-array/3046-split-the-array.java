class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] numbers = new int[101];

        // for (int i: nums) {   It is also valid .
        //    if (++numbers[i] > 2) return false; 
        //  }

        for (int i: nums) { 
            if (numbers[i]++ >= 2) 
                return false; 
        }

        return true;
    }
}