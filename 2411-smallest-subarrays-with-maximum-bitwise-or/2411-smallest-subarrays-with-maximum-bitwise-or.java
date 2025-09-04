class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int last[] =new int[30];
        int res[]=new int[n];

        for(int i=n-1;i>=0;--i){
            res[i]=1;
            for(int j=0;j<30;++j){
                if((nums[i] & (1 << j)) > 0)
                    last[j]=i;
                res[i]=Math.max(res[i],last[j]-i+1);
            }
        }
        return res;
        
    }
}