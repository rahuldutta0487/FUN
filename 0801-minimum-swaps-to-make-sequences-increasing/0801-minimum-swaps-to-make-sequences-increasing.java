class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int a=1,b=0;
        for(int i=1;i<nums1.length;i++){
            int c=nums1.length+1,d=nums1.length+1;
            if(nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i]){
                c=a+1;
                d=b;
            }
            if(nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i]){
                c=Math.min(c,b+1);
                d=Math.min(a,d);
            }
            a=c;
            b=d;
        }
        return Math.min(a,b);
    }
}