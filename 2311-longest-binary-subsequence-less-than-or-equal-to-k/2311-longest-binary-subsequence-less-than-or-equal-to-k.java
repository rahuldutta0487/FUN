// class Solution {
//     public int longestSubsequence(String s, int k) {
//         int res = 0;
//         long cur = 0;
//         for(int i = s.length() - 1; i >= 0; --i) {
//             char c = s.charAt(i);
//             if(c == '0') {
//                 res++;
//             } else if(res < 31 && cur + (1L << res) <= k) {
//                 cur += 1L << res;
//                 res++;
//             }
//         }
//         return res;
//     }
// }
class Solution { // old code, resubmit
    public int longestSubsequence(String s, int k) {
        int length = -1;
        long cur = 0;
        int i = s.length();
        char[] cs = s.toCharArray();
        long addpos = 0;
        while (--i >= 0) {
            cur += ((long)(cs[i] - '0') << addpos++);
            //System.out.println(i+": "+cur);
            if (cur > k) {
                length = cs.length - i - 1;
                break;
            }
        }
        //System.out.println(actual+" "+i);
        if (length == -1) return cs.length;
        while (i >= 0) length += ('1' - cs[i--]);
        return length;
    }
}