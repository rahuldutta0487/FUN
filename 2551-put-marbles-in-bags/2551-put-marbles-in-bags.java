class Solution {
    public long putMarbles(int[] weights, int k) 
    {
        if(k==1)
        {
        	return 0;
        }
        
        List<Integer> pairSums = new ArrayList<Integer>();
        
        for(int i=0;i<weights.length-1;i++)
        {
        	pairSums.add(weights[i]+weights[i+1]);
        }
        
        Collections.sort(pairSums);
        
        long minScore = 0, maxScore = 0;
        
        for(int i=0;i<k-1;i++)
        {
        	minScore+=pairSums.get(i);
        	maxScore+=pairSums.get(pairSums.size()-i-1);
        }
        
        return maxScore-minScore;        
    }
}