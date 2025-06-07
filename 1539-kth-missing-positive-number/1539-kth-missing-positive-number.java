class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length, count = arr[0]-1;
        if(len==1) {
            if(arr[0] > k) return k;
            else if (arr[0]<=k) return k+1;
        }
        if(count >= k) return k;
        for(int i = 1; i < len; i++) {
            count += arr[i]-arr[i-1]-1;
            //System.out.println(count+", "+(k-count)+", "+arr[i]);
            if(count == k) return arr[i]-1;
            if(count > k) return arr[i]-1-(count-k);
        }
        return arr[len-1]-(count-k);
    }
}