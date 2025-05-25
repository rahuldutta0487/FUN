class Solution {
    public int[] canSeePersonsCount(int[] nums) {
        int[] res = new int[nums.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<nums.length;i++) {
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                res[st.pop()]++;
            }
            if(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                res[st.peek()]++;
            }
            st.push(i);
        }
        return res;
        
    }
}