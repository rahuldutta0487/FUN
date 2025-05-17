class Solution {
    private final int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public int minTimeToReach(int[][] moveTime) 
    {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        int result[][] = new int[n][m];
        
        for(int row[]: result)
        {
        	Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        
        result[0][0] = 0;
        
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty())
        {
        	int curr[] = pq.poll();
        	
        	int currTime = curr[0];
        	int i = curr[1];
        	int j = curr[2];
        	
        	if(i==n-1 && j==m-1)
        	{
        		return currTime;
        	}
        	
        	for(int dir[]: directions)
        	{
        		int new_i = i+dir[0];
        		int new_j = j+dir[1];
        		
        		if(new_i>=0 && new_i<n && new_j>=0 && new_j<m)
        		{
        			int wait = Math.max(moveTime[new_i][new_j]-currTime, 0);
        			int finalTime = wait + currTime + 1;
        			
        			if(result[new_i][new_j]>finalTime)
        			{
        				result[new_i][new_j] = finalTime;
        				
        				pq.offer(new int[]{finalTime, new_i, new_j});
        			}
        		}
        	}
        }
        
        return -1;
    }
}