class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        String[] output = new String[queries.length];
        Map<String, String> m = new HashMap<>();
        Map<String, String> m2 = new HashMap<>();

        for(int i=0; i<queries.length; i++) {
            output[i] = "";
        }

        for(int i=wordlist.length-1; i>=0; i--) {
            String word = wordlist[i];
            words.add(word);
            m.put(word.toLowerCase(), word);

            String temp = wordlist[i].toLowerCase();
            StringBuilder sb = new StringBuilder(""); 
            for(int j=0; j<temp.length(); j++) {
                char c = temp.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    sb.append('-');
                } else {
                    sb.append(c);
                }
            }
            m2.put(sb.toString(), word);
        }

        int idx = 0;
        for(String query : queries) {
            if(words.contains(query)) {
                output[idx] = query;
            } else if(m.containsKey(query.toLowerCase())) {
                output[idx] = m.get(query.toLowerCase());
            } else {
                StringBuilder sb = new StringBuilder("");
                String temp = query.toLowerCase();
                for(int i=0; i<temp.length(); i++) {
                    char c = temp.charAt(i);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        sb.append('-');
                    } else {
                        sb.append(c);
                    }
                }
                if(m2.containsKey(sb.toString())) {
                    output[idx] = m2.get(sb.toString());
                }
            }
            idx++;
        }

        return output;
    }
}