class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int i=0,j=0;
        while(j<arr.length){
            sum += arr[j];
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                if(sum/k >= threshold) {
                    count++;
                }
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return count;
    }
}