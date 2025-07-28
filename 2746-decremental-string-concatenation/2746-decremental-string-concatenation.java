class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        // Init
        int sum = 0;
        int n = words.length;
        
        char start = words[0].charAt(0);
        char end = words[0].charAt(words[0].length()-1);
        HashMap<String, Integer> lastMap = new HashMap<String, Integer>(){{
            put(start+","+end, 0);
        }};
        
        // Cal Total Length
        for(String word : words) {
            sum += word.length();
        }
        
        // Iterate all words
        for(int i = 1; i < n; i++) {
            HashMap<String, Integer> newMap = new HashMap<>();
            
            char newStart = words[i].charAt(0);
            char newEnd = words[i].charAt(words[i].length()-1);
            
            // Chech and update all possible start and end in every stage.
            for(String lastString : lastMap.keySet()) {
                Integer count = lastMap.get(lastString);
                char oldStart = lastString.charAt(0);
                char oldEnd = lastString.charAt(2);
                
                String newString1 = oldStart + "," + newEnd;
                String newString2 = newStart + "," + oldEnd;
                
                addMaxValue(newMap, newString1, (newStart == oldEnd)? count+1 : count);
                addMaxValue(newMap, newString2, (newEnd == oldStart)? count+1 : count);
            }
            
            lastMap = newMap;
        }
        
        int max = Collections.max(lastMap.values());
        
        return sum - max;
    }
    
    private void addMaxValue(HashMap<String, Integer> map, String key, Integer val) {
        if(map.containsKey(key)) {
            Integer oldVal = map.get(key);
            
            if(val > oldVal) {
                map.replace(key, val);
            }
        } else {
            map.put(key, val);
        }
    }
}