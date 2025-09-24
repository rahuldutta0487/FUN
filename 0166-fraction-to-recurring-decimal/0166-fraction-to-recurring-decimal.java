class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
        boolean negative = ((numerator1<0 && denominator1>0)|| (numerator1>0 && denominator1<0));
        System.out.println(negative);
        long numerator =  (long)Math.abs(Long.valueOf(numerator1));
        long denominator = (long) Math.abs(Long.valueOf(denominator1));
        long remainder = numerator%denominator;
        long quotient =  numerator/denominator;
        StringBuilder ans = new StringBuilder();
        if(negative)
            ans.append("-");
        ans.append(quotient);
        if(remainder==0)
            return ans.toString();
        Map<Long,Integer> map = new HashMap();
       
        ans.append('.');
        System.out.println(remainder);
        while(remainder!=0)
        {
            if(map.containsKey(remainder))
            {
                ans.insert(map.get(remainder),"(");
                ans.append(")");
                return ans.toString();
            }
            else
            {
                map.put(remainder,ans.length());
                remainder = remainder*10;
                quotient =  remainder/denominator;
                
                remainder = remainder%denominator;
                ans.append(quotient);

            }
            
        }
        return ans.toString();
    }
}