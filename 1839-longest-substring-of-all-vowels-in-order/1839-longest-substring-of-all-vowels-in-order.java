
class Solution {
  

    public int longestBeautifulSubstring(String word) {
        int j=0,ans=0,n=word.length();
        for(int i=0;i<n;i++){
            if(word.charAt(i)=='a'){
            int cnt=0;
            for(j=i+1;j<n && word.charAt(j-1)<=word.charAt(j);j++)
                cnt+=word.charAt(j-1)<word.charAt(j)?1:0;
            
                if(cnt==4) ans=Math.max(ans,j-i);
                i=j-1;
            }
        }
        return ans;

    }
}