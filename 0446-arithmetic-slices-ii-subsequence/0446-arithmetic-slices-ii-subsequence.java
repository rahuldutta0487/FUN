class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            maps[i] = new HashMap<>();
        }
        for(int i=1; i<maps.length; i++) {
            for(int j=0; j<i; j++) {
                long cd = (long)nums[i] - (long)nums[j]; //cd = common difference
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue;
                }

                int apsEndingOnJ = maps[j].getOrDefault((int)cd, 0);
                int apsEndingOnI = maps[i].getOrDefault((int)cd, 0);

                ans += apsEndingOnJ;
                maps[i].put((int)cd, apsEndingOnI + apsEndingOnJ + 1);
            }
        }
        return ans;
    }
}