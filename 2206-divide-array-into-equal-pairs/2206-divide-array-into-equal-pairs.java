class Solution {
    public boolean divideArray(int[] nums) {
        int[] ans = new int[1001];

        for (int x : nums) ans[x]++;

        for(int x:ans) if(x%2 != 0){return false;}
        
        return true;
    }
}