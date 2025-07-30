class Solution {
    private int max = 0;
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        List<Integer>[] neigh = new List[n];
        for(int i = 0; i < n; i++) {
            neigh[i] = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(statements[i][j] != 2) {
                    neigh[i].add(j);
                }
            }
        }
        dfs(0, neigh, 0, 0, statements);
        return max;
    }
    
    private void dfs(int curPerson, List<Integer>[] neigh, int goodGroup, int badGroup, int[][] statements) {
        if(curPerson == statements.length) {
            max = Math.max(Integer.bitCount(goodGroup), max);
            return;
        }
        int d = 1 << curPerson;
        //is bad guy
        if((d & badGroup) != 0) {
            dfs(curPerson + 1, neigh, goodGroup, badGroup, statements);
            return;
        }
        int max = 0;
        //not bad and not good, not sure => so we try bad guy on current person
        if((d & goodGroup) == 0) {
            dfs(curPerson + 1, neigh, goodGroup, badGroup | d, statements);
        }
        //try good guy on current person => verify his word, if he is not conflicting with other good person 
        if(!valid(curPerson, neigh[curPerson], goodGroup, badGroup, statements)) {
            return;
        }
        for(int p: neigh[curPerson]) {
            if(statements[curPerson][p] == 1) {
                goodGroup |= (1 << p);
            } else if(statements[curPerson][p] == 0) {
                badGroup |= (1 << p);
            }
        }
        dfs(curPerson + 1, neigh, goodGroup | d, badGroup, statements);
    }
    
    private boolean valid(int curPerson, List<Integer> relatedPeople, int goodGroup, int badGroup, int[][] statements) {
        for(int p: relatedPeople) {
            if(statements[curPerson][p] == 1 && ((1 << p) & goodGroup) == 0 && ((1 << p) & badGroup) != 0) {
                return false;
            } 
            if(statements[curPerson][p] == 0 && ((1 << p) & goodGroup) != 0 && ((1 << p) & badGroup) == 0) {
                return false;
            }
        }
        return true;
    }
    
//     public int maximumGood(int[][] statements) {
//         int n = statements.length;
//         int len = 1 << n;
//         int ans = 0;
//         for(int v = 1; v < len; v++) {
//             if(isValid(statements, v, n)) {
//                 ans = Math.max(Integer.bitCount(v), ans);
//             }
//         }
//         return ans;
//     }
    
//     private boolean isValid(int[][] stat, int v, int n) {
//         for(int i = 0; i < n; i++) {
//             if((v & (1 << i)) == 0) {
//                 continue;
//             }
//             for(int j = 0; j < n; j++) {
//                 if(stat[i][j] == 1 && (v & (1 << j)) == 0) {
//                     return false;
//                 } else if(stat[i][j] == 0 && (v & (1 << j)) != 0) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
}