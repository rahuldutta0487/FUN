class Solution {
    
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();

        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<String, Integer> freqMap = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < n) {

            char current = s.charAt(right);
            charMap.put(current, charMap.getOrDefault(current, 0) + 1);

            while (charMap.size() > maxLetters || right - left + 1 > minSize) {
                char leftChar = s.charAt(left);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if (charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }
                left++;
            }

            if (right - left + 1 == minSize) {
                String substring = s.substring(left,right+1);
                freqMap.put(substring,freqMap.getOrDefault(substring,0)+1);
            }
            right++;

        }

        int max =0;
        for(String str : freqMap.keySet()){
            max = Math.max(max,freqMap.get(str));
        }
        return max;

    }
}