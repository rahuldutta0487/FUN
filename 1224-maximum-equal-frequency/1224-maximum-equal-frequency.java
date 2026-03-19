class Solution {
    public int maxEqualFreq(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        int count[] = new int[100001];

        int max = 0;
        Iterator<Integer> it;
        for(int i = 0; i < nums.length; i++) {
            if ( count[nums[i]] > 0 ) {
                int cnt = countMap.get(count[nums[i]]);
                if ( cnt  == 1 ) countMap.remove(count[nums[i]]);
                else countMap.put(count[nums[i]], cnt-1);
            }

            count[nums[i]]++;
            countMap.put(count[nums[i]], countMap.getOrDefault(count[nums[i]], 0)+1);

            

            // System.out.println(countMap);

            if ( countMap.size() == 2 ) {
                it = countMap.keySet().iterator();
                List<int[]> list = new ArrayList<int[]>();

                while(it.hasNext()) {
                    int cnt = it.next();
                    int cntCnt = countMap.get(cnt);

                    list.add(new int[]{cnt, cntCnt});
                }

                Collections.sort(list, new Comparator<int[]>() {

                    @Override
                    public int compare(int[] arg0, int[] arg1) {
                        return arg0[0] -arg1[0];
                    }
                    
                });

                if ( list.get(0)[0] == 1 && list.get(0)[1] == 1 ) {
                    max = Math.max(max, list.get(1)[0] * list.get(1)[1] +1) ;
                }

                if ( list.get(0)[0] + 1 == list.get(1)[0] && list.get(1)[1] == 1) {
                    max = Math.max(max, list.get(0)[0] * (list.get(0)[1]+1)+1) ;
                }
            }
        }

        return max==0?nums.length:max;  
    }
}