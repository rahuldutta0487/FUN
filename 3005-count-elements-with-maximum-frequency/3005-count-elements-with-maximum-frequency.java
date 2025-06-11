class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int element=nums[i];
            if(m.containsKey(element)){
                m.put(element,m.get(element)+1);
            }else{
                m.put(element,1);
            }
        }
        int max=0;
        int count=0;
        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            if(e.getValue()>max){
                max=e.getValue();
                count=max;
            }else if(e.getValue()==max){
                count+=max;
            }
        }
        return count;
        
    }
}