class Solution {
    public int maxFreqSum(String s) {
        int[] vowelFreq = new int[26], consonantFreq = new int[26];
        
        boolean[] isVowel = new boolean[26];
        char[] vowels = {'a','e','i','o','u'};
        for (char v : vowels) {
            isVowel[v - 'a'] = true;
        }
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (isVowel[idx]) {
                vowelFreq[idx]++;
            } else {
                consonantFreq[idx]++;
            }
        }
        
        int maxVowel = 0;
        for (int freq : vowelFreq) {
            if (freq > maxVowel) {
                maxVowel = freq;
            }
        }
        
        int maxConsonant = 0;
        for (int freq : consonantFreq) {
            if (freq > maxConsonant) {
                maxConsonant = freq;
            }
        }
        
        return maxVowel + maxConsonant;
    }
}