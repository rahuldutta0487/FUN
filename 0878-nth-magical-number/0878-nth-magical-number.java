class Solution {
    public long LCM(int a, int b){
        return (a*(long)b)/GCD(a,b);
    }
    public long GCD(int a,int b){
        if(b==0)return a;
        return GCD(b,a%b);
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long ans=0;
        long start=Math.min(a,b);
        long end=(long)n*Math.min(a,b);
        long lcm=LCM(a,b);
        long mod=1000000007;
        while(start<=end){
            long mid= start+(end-start)/2;
            long multiples=mid/a +mid/b-mid/lcm;
            if(multiples>=n){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        ans= ans%mod;
        return (int)(ans);
    }
}