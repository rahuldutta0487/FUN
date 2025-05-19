
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();  // A list to store the resultant subarray
        int low = 0;                                    // A var to point at the left half of the array
        int high = arr.length - 1;                      // A var to point at the right half of the array
        
        while(high - low >= k){                         // Traverse till the difference between 'high' and 'low' is not less than 'k'
            int distLow = Math.abs(arr[low] - x);       // Get the difference between 'x' and the element at index 'low' in 'distLow'
            int distHigh = Math.abs(arr[high] - x);     // Get the difference between 'x' and the element at index 'high' in 'distHigh'
            
            if(distLow <= distHigh)                     // Now, check if 'distLow' less than or equal 'distHigh' or not
                high--;                                 // If Yes, then move the right pointer i.e., decrease the value of 'high' 
            else                                        // Else,
                low++;                                  // Move the left pointer i.e., increase the value of 'low'
        }
        while(low <= high)                              // After traversing the array, traverse another loop to get the resultant values
            list.add(arr[low++]);                       // And, keep adding those values to the resultant list
        
        return list;                                    // Finally, return the resultant list
    }
}