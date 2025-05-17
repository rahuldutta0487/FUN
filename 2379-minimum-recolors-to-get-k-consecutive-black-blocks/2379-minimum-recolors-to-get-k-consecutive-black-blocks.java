class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        
        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        int minWhite = whiteCount;
        
        // Slide the window across the string
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++; // add new block
            }
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--; // remove old block
            }
            minWhite = Math.min(minWhite, whiteCount);
        }
        
        return minWhite;
    }
}