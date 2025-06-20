class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
        return -1;
        int[][] mem=new int[jobDifficulty.length+1][d+1];
        for(int[] arr : mem) Arrays.fill(arr, -1);
        return minDiff(jobDifficulty,d,0,mem);
    }
    public int minDiff(int[] job,int d,int ind,int[][] mem){
        if(d==1){
            int mx=0;
            for(int i=ind;i<job.length;i++){
                mx=Math.max(mx,job[i]);
            }
            return mx;
        }
        if(mem[ind][d]!=-1)
         return mem[ind][d];
        int mx=0;
        int min=Integer.MAX_VALUE;
        for(int i=ind;i<=job.length-d;i++){
            mx=Math.max(mx,job[i]);
            min= Math.min(min,mx+minDiff(job,d-1,i+1,mem));
        }
        return mem[ind][d]=min;
    }
}