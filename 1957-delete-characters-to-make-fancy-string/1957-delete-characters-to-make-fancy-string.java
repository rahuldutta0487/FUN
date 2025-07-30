class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        if(s.length()<=2){
            sb.append(s);
            return sb.toString();
        }
        int left=0,right=0;
        for(int i=1;i<s.length()-1;i++){
            left=i-1;
            right=i+1;
            if(s.charAt(left)==s.charAt(i)&&s.charAt(i)==s.charAt(right)) continue;
            sb.append(s.charAt(left));
        }
        sb.append(s.charAt(right-1));
        sb.append(s.charAt(right));
        return sb.toString();
    }
}