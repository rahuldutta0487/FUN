class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) 
    {
        int ans=0;

        for(int i:fruits)
        {
            boolean flag=true;
            for(int j=0;j<baskets.length;j++)
            {
                if(i<=baskets[j])
                {
                    baskets[j]=0;
                    flag=false;
                    break;
                }
            }
            if(flag)
            ans++;
        }
        return ans;
        
    }
}