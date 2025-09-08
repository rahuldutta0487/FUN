class Solution {
    public int[] getNoZeroIntegers(int n) {
      
  
       for(int i=1;i<=n;i++){
            int left = i;
            int right = n-i;
            if(left>0 && right>0 && iscontainsZero(left) == false && iscontainsZero(right) == false){
                return new int[]{left,right};
            }
       }
    
    return new int[] {-1,-1};
    }
    public boolean iscontainsZero(int n){
        while(n > 0){
            int digits = n % 10;
            if(digits == 0) return true;
            n /= 10;
        }
        return false;
    }
}