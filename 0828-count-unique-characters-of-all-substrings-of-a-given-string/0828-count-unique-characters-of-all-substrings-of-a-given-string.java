class Solution {
    public int uniqueLetterString(String str) {
        int res = 0;
        for (int j = 0; j < 26; j++) {
            char ch = (char)('A' + j);
            List<Integer> position = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ch) {
                    position.add(i);
                }
            }
            
            int p = 0;
            int s = 0;
            
            for (int i = 0; i < position.size(); i++) {
                if (i == 0) {
                    p = position.get(i);
                } else {
                    p = position.get(i) - position.get(i-1) - 1;
                }
                if (i == position.size() - 1) {
                    s = str.length() - position.get(i) - 1;
                } else {
                    s = position.get(i + 1) - position.get(i) - 1;
                }
                
                res += s*p + s + p + 1;
            }
        }
        return res;
    }
}