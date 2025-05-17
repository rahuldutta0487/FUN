class Solution {
    public int tupleSameProduct(int[] nums) {
        int N=nums.length;
        int res=0;

        // Create a hash map to store product frequencies
        Map<Integer, Integer> map=new HashMap<>();

        // Iterate through all pairs of numbers
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                // Increment the count of this product in the hash map
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }

        // Iterate through the hash map to count valid tuples
        for(Map.Entry<Integer, Integer> enty:map.entrySet()){
            if(enty.getValue()>=2){
                // Get the count of pairs with the same product
                int n=enty.getValue();
                
                // Calculate the number of valid tuples and add to the result
                res+=8*(n*(n-1)/2);    
                //Hints: 
                //    1. Pair = nC2 = n*(n-1)/2
                //    2. Each Pair is having 8 tuples
                
            }
        }

        return res;
    }


}