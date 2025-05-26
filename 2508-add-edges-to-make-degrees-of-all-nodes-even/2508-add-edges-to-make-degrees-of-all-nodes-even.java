class Solution {
   
    List<Set<Integer>> adjList;
    
    public boolean isPossible(int n, List<List<Integer>> edges) {
        adjList = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            adjList.add(new HashSet<>());
        }
        for(List<Integer> edge: edges) {
            int x = edge.get(0) - 1, y = edge.get(1) - 1;
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        int cntOdd = 0;
        for(int i = 0; i< n; i++) {
            if(adjList.get(i).size() % 2 == 1) {
                cntOdd ++;
                odds.add(i);
            }
        }
        if(cntOdd == 0)
            return true;
        else if(cntOdd == 2) {
            Integer u = odds.get(0), v = odds.get(1);
            for(int k = 0; k<n; k++) {
                if(!adjList.get(k).contains(u) && !adjList.get(k).contains(v)) {
                    return true;
                }
            }
        } else if(cntOdd == 4) {
            int a = odds.get(0), b = odds.get(1), c = odds.get(2), d = odds.get(3);
            if((!adjList.get(a).contains(b) && !adjList.get(c).contains(d))
               || (!adjList.get(b).contains(c) && !adjList.get(a).contains(d))
               || (!adjList.get(a).contains(c) && !adjList.get(b).contains(d))
              ) {
                return true;
            }
        }
        return false;
    }
}