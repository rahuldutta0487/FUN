class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
/*
// Runable but time limit Exceed......
        int size = nums.length;
        int []dp = new int[size];
        int res = Integer.MIN_VALUE;

        for(int i=0; i<size; i++){
            int temp=0;
            for(int j=Math.max(i-k, 0); j<i; j++){
                temp = Math.max(temp, dp[j]);
            }

            dp[i] = nums[i]+temp;
            res = Math.max(res, dp[i]);
        }

        return res;
*/

        Deque<Integer> dq = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int temp = Math.max(0, dq.isEmpty()?0:nums[dq.peekFirst()]);
            nums[i] += temp;
            res = Math.max(res, nums[i]);

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i-dq.peekFirst()+1 > k){
                dq.removeFirst();
            }
        }

        return res;
    }
}