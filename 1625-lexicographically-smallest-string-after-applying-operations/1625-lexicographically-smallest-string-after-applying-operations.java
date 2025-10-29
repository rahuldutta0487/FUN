class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String result = s;

        queue.offer(s);
        visited.add(s);

        while(!queue.isEmpty()){
            String curr = queue.poll();
            
            if(curr.compareTo(result)<0){
                result = curr;
            }
            String rotate = rotate(curr,b);
            if(!visited.contains(rotate)){
                visited.add(rotate);
                queue.offer(rotate);
            }

            String add = add(curr,a);
            if(!visited.contains(add)){
                visited.add(add);
                queue.offer(add);
            }
            
        }

        return result;
    }

    private String rotate (String s , int b){
        StringBuilder str = new StringBuilder();

        int n = s.length(); 
        for(int i = n-b ; i<n;i++){
            str.append(s.charAt(i));
        }

        for(int i =0 ; i<n-b ; i++){
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    private String add(String s , int a ){
        int[] digit = new int[s.length()];

        for(int i = 0 ; i < s.length() ; i++){
            digit[i] = s.charAt(i) - '0';
        }

        for(int i = 1 ; i < s.length() ; i++){
            
            if(i%2!=0){int add = digit[i] + a;

            if(add > 9){
                digit[i] = add%10;
            }else{
                digit[i] = add;
            }}
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i<digit.length ; i++){
            str.append(digit[i]);
        }
        return str.toString();
    }
}