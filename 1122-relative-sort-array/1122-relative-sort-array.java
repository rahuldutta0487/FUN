class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] ans = new int[arr1.length];
        int j = 0;
        for(int i=0;i<arr1.length;i++){
            freq[arr1[i]]++;
        }

        for(int i=0;i<arr2.length;i++){
            int cnt = freq[arr2[i]];
            for(int k = 0;k<cnt;k++){
                ans[j] = arr2[i];
                j++;
                freq[arr2[i]]--;

            }
        }

        for(int i=0; i< 1001;i++){
            
            if(freq[i] > 0){
                  int cnt = freq[i];
                   for(int k = 0;k<cnt;k++){
                ans[j] = i;
                j++;
                freq[i]--;

            }
            }
        }

        

        return ans;
    }
}