class Solution {
    private static final int[][] dir = {{1,3}, {0,2,4}, {1,5}, {0,4}, {3, 1, 5}, {4,2}};
    public List<String> getNeighbors(String current, int zeroIndex) {
        List<String> neighbors = new ArrayList();
        for (int move : dir[zeroIndex]) {
            StringBuilder next = new StringBuilder(current);
            next.setCharAt(zeroIndex, next.charAt(move));
            next.setCharAt(move, '0');  
            neighbors.add(next.toString());       
        }
        return neighbors;
    }

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        StringBuilder start = new StringBuilder();

       for (var row : board) {
            for (var col : row) {
                start.append(col);
            }
       }

       q.offer(start.toString());
       visited.add(start.toString());
       int step = 0;

       while (!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String current = q.poll();
                if (current.equals(target)) return step;
                int zeroIndex = current.indexOf('0');
                for (String neighbor : getNeighbors(current, zeroIndex)) {                    
                    if (!visited.contains(neighbor.toString())) {
                        visited.add(neighbor.toString());
                        q.offer(neighbor.toString());
                    }                    
                    
                }
            }     
            step++;       
        }

        return -1;
    }
}