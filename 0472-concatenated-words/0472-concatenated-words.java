class Solution {
    Trie root;
    List<String> res = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        for (String word : words) {
            if (dfs(word, 0, 0)) {
                res.add(word);
            } else {
                addToTrie(word);
            }
        }
        return res;
    }

    public boolean dfs(String word, int index, int count) {
        if (index == word.length()) {
            return count >= 2;
        }
        Trie node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
            if (node.isEnd && dfs(word, i + 1, count + 1)) {
                return true;
            }
        }
        return false;
    }

    public void addToTrie(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}