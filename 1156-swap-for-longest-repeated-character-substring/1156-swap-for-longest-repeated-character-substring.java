class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int result = 0;
        
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
            result = Math.max(result, count[c - 'a']);
        }
        
        if (result <= 1) return result;
        
        int maxResult = 1;
        int start = 0;
        int length = text.length();
        
        while (start < length) {
            int left = start;
            char character = text.charAt(start);
            while (start < length && text.charAt(start) == character) start++;
            
            int end = start + 1;
            while (end < length && text.charAt(end) == character) end++;
            
            int currLength = (end - left - 1 == count[character - 'a']) ? end - left - 1 : end - left;
            maxResult = Math.max(maxResult, currLength);
            start = start;
        }
        
        return maxResult;
    }
}