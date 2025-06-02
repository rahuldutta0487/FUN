class Solution {
    public boolean isPossible(long num,int x,long k){
        long total = 0;
        for(int i = 1;i<=62;i++){
            if(i%x==0){
                long groupSize = (long)Math.pow(2,i);
                long onesPerEachGroup = (long)Math.pow(2,i-1);
                long totalGroups = num/groupSize;
                total+=totalGroups*onesPerEachGroup;
                long rem = (num%groupSize+1-onesPerEachGroup);
                total+=Math.max(0,rem);
                if(total>k) return false;
            }
        }
        return true;
    }
    public long findMaximumNumber(long k, int x) {
        long low = 1L;
        long high = (long)1e15;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(isPossible(mid,x,k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return  high;
    }
}