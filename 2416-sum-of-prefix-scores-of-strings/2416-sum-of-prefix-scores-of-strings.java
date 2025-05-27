class Trie {
    Trie[] arr = new Trie[26];
    int count = 0;
}
class Solution {

    Trie root = new Trie();

    void add_word(String str) {
        Trie curr = root;
        int ind;
        for(char ch : str.toCharArray()) {
            ind = ch - 'a';
            if(curr.arr[ind] == null) curr.arr[ind] = new Trie();
            curr = curr.arr[ind];
            curr.count++;
        }
    }
    int get_value(String str) {
        Trie curr = root;
        int ind;
        int count = 0;
        for(char ch : str.toCharArray()) {
            ind = ch - 'a';
            if(curr.arr[ind] == null) return count;
            curr = curr.arr[ind];
            count += curr.count;
        }
        return count;
    }
    public int[] sumPrefixScores(String[] words) {
        for(String str : words) {
            add_word(str);
        }
        int result[] = new int[words.length];
        int ind = 0;
        for(String str : words) {
            result[ind++] = get_value(str);
        }
        return result;
    }
}