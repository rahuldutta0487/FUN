class Solution {
    public String smallestGoodBase(String n) {
        // using Binary Search
     long num=Long.valueOf(n);
        for(int m=61;m>2;m--){
            long lo=2,hi=num-1;
            while(lo<=hi){
                long mid=(lo+hi)/2;
                int flag=0;
                long val=1,j=1,res=1;
                while(j<m){
                    if(val>(num-res)/mid){
                        flag=1;
                        break;
                    }
                    j++;
                    val*=mid;
                    res+=val;
                }
                if(flag==1||res>num) hi=mid-1;
                else if(res<num) lo=mid+1;
                else return String.valueOf(mid);
            }
        }
        return String.valueOf(num-1);
    }
}