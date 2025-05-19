class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max = 0;
        int cur = 0;
        int cur2 = 0;
        int left = 0;
        int left2 = 0;
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(i < firstLen){
                cur += nums[i];
            }
            else{
                cur += nums[i];
                cur -= nums[left];
                left++;
            }
            arr1[i] = cur;
            if(i < secondLen){
                cur2 += nums[i];
            }
            else{
                cur2 += nums[i];
                cur2 -= nums[left2];
                left2++;
            }
            arr2[i] = cur2;
        }
        for(int i = 0; i<arr1.length; i++){
            int number = arr1[i];
            int left_max = 0;
            int right_max = 0;
            int j = i - firstLen;
            int k = i + secondLen;
            while(j >= 0){
                left_max = Math.max(left_max,arr2[j]);
                j--;
            }
            while(k < arr1.length){
                right_max = Math.max(right_max,arr2[k]);
                k++;
            }
            int rl_max = Math.max(left_max,right_max);
            max = Math.max(max,number+rl_max);
        }
        return max;
    }
}