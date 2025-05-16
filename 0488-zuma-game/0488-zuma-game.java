class Solution {
    HashMap<String,Integer>hm;
    public int findMinStep(String board, String hand) {
        hm=new HashMap<>();
        int ans=f(board,hand);
       // System.out.println(ff("AAABBBBABBB"));
        if(ans>=100)return -1;
        
        return ans;
    }
    public int f(String b,String h){
        String k=b+"#"+h;
        if(hm.containsKey(k)){
            return hm.get(k);
        }
         b=ff(b);
        int n=b.length();
        int m=h.length();
        if(n==0){
            hm.put(k,0);
            return 0;
        }
        if(m==0){
            
            if(n==0){
                hm.put(k,0);
                return 0;
            }
        hm.put(k,100);
            return 100;
        }
        int ans=100;
         
        for(int i=0;i<h.length();i++){
            char ch=h.charAt(i);
        //    ans=Math.min(ans,1+f(ff(ch+b),h.substring(0,i-1)+h.substring(i+1)))
            for(int j=0;j<b.length();j++){
               if(b.charAt(j)==h.charAt(i)||(j!=n-1&&b.charAt(j)==b.charAt(j+1))){
                ans=Math.min(ans,1+f(b.substring(0,j+1)+ch+b.substring(j+1,n),h.substring(0,i)+h.substring(i+1,m)));

               }
               
            }
           
        }
         hm.put(k,ans);
            return ans;
    }
    public String ff(String s){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
             st.push(ch);
            if(st.size()>=3&&(i==s.length()-1||s.charAt(i)!=s.charAt(i+1))){
             char a=st.pop();
             char b=st.pop();
             char c=st.pop();
             if(a==b&&b==c){
                while(st.size()>0&&st.peek()==a){
                    st.pop();
                }
             }
             else{
                st.push(c);
                st.push(b);
                st.push(a);
             }
            }
        }
            StringBuilder sb=new StringBuilder();
            while(st.size()>0){
                sb.append(st.pop());
            }
            
            return sb.toString();

        
    }
}