class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int res[] = new int[students.length];
        boolean vis[] = new boolean[students.length];
        return find(0, res, students, mentors, vis);
    }

    int find(int index, int[] res, int[][] students, int[][] mentors, boolean[] vis) {
        if (index == students.length) {
            int r = 0;
            for (int i = 0; i < students.length; i++) {
                r += res[i];
            }
            return r;
        }

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < students.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                int t = 0;
                for (int j = 0; j < students[0].length; j++) 
                {
                    if (students[index][j] == mentors[i][j]) 
                    {
                        t++;
                    }
                }

                res[i] = t;
                maxi = Math.max(maxi, find(index + 1, res, students, mentors, vis));

                res[i] = 0; 
                vis[i] = false;  
            }
        }
        return maxi;
    }
}