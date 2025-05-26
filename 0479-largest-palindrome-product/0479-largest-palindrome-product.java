class Solution {
    public long palindrome(long d){
       String s= new StringBuilder().append(d).reverse().toString();
return Long.valueOf(d+s);
    
    }
    public int largestPalindrome(int n) {
  
        long j=(int)Math.pow(10,n-1);
        long k=(int)Math.pow(10,n);
                int max=0;
        for(long i=k-1;i>j;i--){
            long kk=palindrome(i);
            for(long l=k-1;l*l>=kk;l--){
              
                if(kk%l==0)
                return (int)(kk%1337);
            }
        }
         return 9;

    
    }
}