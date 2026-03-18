class Solution {
    public long maxTotal(int[] value, int[] limit) {
        long sum =0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = value.length;
        for(int i=0; i<n; i++){
            if(map.containsKey(limit[i])){
                List<Integer> l = map.get(limit[i]);
                l.add(value[i]);
                map.put(limit[i],l);
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(value[i]);
                map.put(limit[i],l);
            }
        }

        for(int key : map.keySet()){
            List<Integer> l = map.get(key);
            Collections.sort(l , Collections.reverseOrder());
            int min = Math.min(key , l.size());
            for(int i=0; i<min; i++){
                sum+=l.get(i);
            }
        }
        return sum;
    }
}