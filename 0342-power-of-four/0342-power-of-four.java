// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if(n == 0)return false;
//         if(n == 1)return true;
        
//         if(n%4 == 0)return isPowerOfFour(n/4);
//         return false;
//     }
// }
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }
}