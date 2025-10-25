class Solution {
    public int totalMoney(int n) {
        int q = n / 7;     
        int r = n % 7;     

        int fullWeeksSum = 28 * q + 7 * q * (q - 1) / 2;

        int leftoverSum = (2 * q + r + 1) * r / 2;

        return fullWeeksSum + leftoverSum;
    }
}