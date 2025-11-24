class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> divisibleByFive = new ArrayList<>(nums.length);
        int n = 0;
        for(int bit : nums) {
            n = (n * 2 + bit) % 10;
            divisibleByFive.add(n == 5 || n == 0);
        }
        return divisibleByFive;
    }
}