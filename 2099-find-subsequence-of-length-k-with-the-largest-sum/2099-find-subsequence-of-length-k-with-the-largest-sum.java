class Solution {
    public int[] maxSubsequence(int[] arr, int k) {
        int n = arr.length;
        if(k==n) return arr;
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int i=0; i<n; i++){
            pq1.add(new int[]{i, arr[i]});
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        for(int i=0; i<k; i++){
            int t[] = pq1.poll();
            pq2.add(new int[]{t[1], t[0]});
        }
        int ans[] = new int[k];
        int idx = 0;
        while(!pq2.isEmpty()){
            int t[] = pq2.poll();
            ans[idx++] = t[0];
        }
        return ans;
    }
}