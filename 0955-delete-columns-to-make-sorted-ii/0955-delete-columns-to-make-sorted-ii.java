class Solution {
    public int minDeletionSize(String[] strs) {

        int row = strs.length;
        int col = strs[0].length();

        boolean[] sorted = new boolean[row];
        int res = 0;

        for (int c = 0; c < col; c++) {
            boolean bad = false;

            for (int r = 1; r < row; r++) {
                if (!sorted[r] && strs[r - 1].charAt(c) > strs[r].charAt(c)) {
                    bad = true;
                    break;
                }
            }

            if (bad) {
                res++;
            } else {
                for (int r = 1; r < row; r++) {
                    if (!sorted[r] && strs[r - 1].charAt(c) < strs[r].charAt(c)) {
                        sorted[r] = true;
                    }
                }
            }
        }
        return res;
    }
}