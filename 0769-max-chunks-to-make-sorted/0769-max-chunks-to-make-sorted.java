class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        int[]expectedSum=new int[arr.length];
        for(int i=0;i<expectedSum.length;i++){
            expectedSum[i]= (i*(i+1))/2;
        }
        int runningSum=0;
        for(int i =0;i<arr.length;i++){
            runningSum+=arr[i];
            if(runningSum==expectedSum[i]){chunks++;}
        }
        return chunks;
    }
}