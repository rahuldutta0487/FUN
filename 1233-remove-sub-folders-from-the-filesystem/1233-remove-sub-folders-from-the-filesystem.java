class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        List<String> ans = new ArrayList<>();
        ans.add(folders[0]);

        for (int i = 1; i < folders.length; i++) {
            String curr = folders[i];
            String prev = ans.get(ans.size() - 1);

            // If `curr` isn't inside `prev`, it's valid
            if (!curr.startsWith(prev + "/")) {
                ans.add(curr);
            }
        }

        return ans;
    }
}