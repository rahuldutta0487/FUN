class Solution {
    public int superpalindromesInRange(String left, String right) {
        long a = Long.parseLong(left);
        long b = Long.parseLong(right);
        int count = 0;
        
        boolean end1 = false;
        boolean end2 = false;
        
        for(long i = 1; i <= b; i++){

            String s = Long.toString(i);
            
            if(!end1){
                StringBuilder x = new StringBuilder(s);
                String x1 = s + (x.reverse().toString());
                

                long val = Long.parseLong(x1);
                long end = val*val;
                String sq = Long.toString(end);
                
                if(end >= a && end <= b && sq.equals(new StringBuilder(sq).reverse().toString())){
                        count++;
                }
                if(end > b)
                    end1 = true;

           }
            
            if(!end2){
           
                StringBuilder x = new StringBuilder(s.substring(0, s.length()-1));
                String x1 = s + (x.reverse().toString());
                long val = Long.parseLong(x1);
                long end = val*val;
                String sq = Long.toString(end);
                if(end >= a && end <= b && sq.equals(new StringBuilder(sq).reverse().toString())){
                        count++;
                }
                if(end > b)
                    end2 = true;
            }
            
            if(end1 && end2)
                break;
            
        }
        return count;
    }
}