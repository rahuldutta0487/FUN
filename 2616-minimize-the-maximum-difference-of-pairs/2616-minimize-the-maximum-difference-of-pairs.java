class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0;
        int r=nums[n-1]-nums[0];
        while(r>l){
            int mid=l+(r-l)/2;
            if(isvalid(nums,mid,p)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return r;
    }
    public static boolean isvalid(int[] nums,int mid,int p){
        int c=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=mid){
                c++;
                i++;
            }
        }
        return c>=p;
    }
}