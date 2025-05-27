class Solution {
    public int countBalls(int lL, int hL) {
        int[] arr = new int[46];
        int max = 0;

        for (int i = lL; i <= hL; i++) {
            int sum = 0,temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            arr[sum]++;
            max = Math.max(max, arr[sum]); 
        }

        return max;
    }
}