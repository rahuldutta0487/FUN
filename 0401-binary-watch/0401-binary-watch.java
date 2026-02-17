class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> readBinaryWatch(int turnedOn) {
        String time="";
        int arr[] = {1,2,4,8,1,2,4,8,16,32};
        findTime(arr,time,turnedOn,0,0,0);
        return ans;
    }
    public void findTime(int[] arr, String time,int limit,int i,int hours,int mins){
        if(limit==0){
            if(hours>11||mins>59) return;
            time=hours+""+":"+(mins<10?"0"+mins:mins+"");
            ans.add(time);
            return;
        }
        for(int j=i;j<arr.length;j++){
            if(j<4){
                hours+=arr[j];
            }else{
                mins+=arr[j];
            }
            findTime(arr,time,limit-1,j+1,hours,mins);
            if(j<4){
                hours-=arr[j];
            }else{
                mins-=arr[j];
            }
        }
    }
}