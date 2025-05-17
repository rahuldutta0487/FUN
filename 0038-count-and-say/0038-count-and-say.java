class Solution {
    public String countAndSay(int n) {
        return solve(n);
    }

    public String solve(int n){
        if(n==1)
            return "1";
        
        String temp = solve(n-1);
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<temp.length(); i++){
            char num = temp.charAt(i);
            int count = 1;
            while(i+1<temp.length() && num == temp.charAt(i+1)){
                count++;
                i++;
            }
            ans.append(count).append(num);
        }

        return ans.toString();
    }
}