class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<answers.length;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        for(int n : map.keySet()){
            if(map.get(n)%(n+1)==0) ans+=map.get(n);
            else{
            ans+=map.get(n)+n+1-map.get(n)%(n+1);
            }

        }
        return ans;
        
    }
}