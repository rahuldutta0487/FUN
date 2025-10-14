class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int last=nums1.length-1;
        int mandatorySwap=0;
        int optionalSwap=0;
        for(int i=nums1.length-2;i>=0;i--){
            //if both of the current two numbers are greater than the the minimun of the two tail, return -1
            if(nums1[i]>Math.min(nums1[last],nums2[last])&&nums2[i]>Math.min(nums1[last],nums2[last]))
                return -1;
            //if the maximum of the current two numbers is greater than the maximun of the two tails, return -1
            if(Math.max(nums1[i],nums2[i])>Math.max(nums1[last],nums2[last]))
                return -1;
            // if only one of the current number is greater than the tail number, then it is required to swap the number
            if(nums1[i]>nums1[last]||nums2[i]>nums2[last]){
                mandatorySwap++;
            }
            // if both the of current number is smaller than any of the tail numbers, then it is optional to change.
            if(nums1[i]<=Math.min(nums1[last],nums2[last])&&nums2[i]<=Math.min(nums1[last],nums2[last])){
                optionalSwap++;
            }
            
        }
        //the final result is either the all required swap or the reverse of all required or non required changed.
        return Math.min(mandatorySwap,nums1.length-mandatorySwap-optionalSwap);
    }
}