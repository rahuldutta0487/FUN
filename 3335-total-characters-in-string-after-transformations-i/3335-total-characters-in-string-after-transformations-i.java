class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int []freq=new int[26];
        int mod=1_000_000_007;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t;i++){
            int num=freq[25];
            for(int j=25;j>=1;j--){
                freq[j]=freq[j-1];
            }
            freq[0]=num;
            freq[1]=(num+freq[1])%mod;
        }
        int sum=0;
        for(int i=0;i<26;i++){
            sum=(freq[i]+sum)%mod;
        }
        return sum;
    }
}