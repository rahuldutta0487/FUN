class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum=0;
        for(int i:nums) sum +=i;
        boolean[][] m=new boolean[nums.length+1][sum+1];
        m[0][0]= true;
        for(int num:nums){
            for(int i=nums.length-1;i>=0;i--){
                for(int j=sum;j>=num;j--){
                    if(m[i][j-num]){
                        m[i+1][j]=true;
                    }
                }
            }
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(m[i][j]){
                    double left=(j+0.0)/i;
                    double right=(sum-j+0.0)/(nums.length-i);
                    if(left == right){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}