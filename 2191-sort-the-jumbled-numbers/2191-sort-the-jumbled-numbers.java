class Solution {
    public void convertToNewSystem(int []newSys,int []mapping ,int []nums){
        int n=nums.length;
        for(int j=0;j<n;j++){
            int num=nums[j];
            if(num==0){
                newSys[j]=mapping[0];
                continue;
            }
            int res=0;
            int i=0;
            while(num>0){
                int d=num%10;
                int newD=mapping[d];
                res=newD*(int)Math.pow(10,i)+res;
                num=num/10;
                i++;
            }
            newSys[j]=res;
        } 
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
      int n=nums.length;
      int newSys[]=new int[n];
      convertToNewSystem(newSys,mapping,nums);
      Integer index[]=new Integer[n];
      for(Integer i=0;i<n;i++){
        index[i]=i;
      }
      Arrays.sort(index, new Comparator<Integer>(){
        public int compare(Integer a,Integer b){
            return newSys[a]-newSys[b];
        }
      });
      int i=0;
      for(int ind: index){
        newSys[i]=nums[ind];
        i++;
      }
      return newSys;
    }
}