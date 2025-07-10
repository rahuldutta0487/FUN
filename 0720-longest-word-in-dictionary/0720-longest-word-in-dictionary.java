class Solution {
    public String longestWord(String[] words) {
        Dictionary dictionary = new Dictionary();

        for(String word : words)
            dictionary.insertWord(word);

        return dictionary.findLongestWord();
    }

    private class Letter {
        public boolean isWord = false;
        public Letter[] children;

        public Letter() {
            this.children = new Letter[26];
        }
    }

    private class Dictionary {
        private Letter root;

        public Dictionary() {
            this.root = new Letter();
            this.root.isWord = false;
        }

        public void insertWord(String word) {
            Letter curr = root;

            for(int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';

                if(curr.children[index] == null)
                    curr.children[index] = new Letter();

                curr = curr.children[index];
            }

            curr.isWord = true;
        }

        public String findLongestWord() {
            return findLongestWordHelper(root);
        }

        private String findLongestWordHelper(Letter root) {
            String longestSuffix = "";

            for(int i = 0; i < 26; ++i) {
                if(root.children[i] == null || !root.children[i].isWord)
                    continue;

                String suffix = (char) (i + 'a') + findLongestWordHelper(root.children[i]);

                if(longestSuffix.length() < suffix.length())
                    longestSuffix = suffix;
            }

            return longestSuffix;
        }
    }
}