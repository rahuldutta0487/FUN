class Solution {
    public int longestValidParentheses(String s) {
        int maxi=0;
        int right = 0;
        int left=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                left++;
            }else if(ch==')'){
                right++;
            }

            if(left==right){
                maxi=Math.max(maxi, 2*left);
            } else if(right>left){
                right=0;
                left=0;
            }
        }
        left=0; right=0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch=='('){
                left++;
            }else if(ch==')'){
                right++;
            }

            if(left==right){
                maxi=Math.max(maxi, 2*right);
            } else if(right<left){
                right=0;
                left=0;
            }
        }

        return maxi;
    }
}