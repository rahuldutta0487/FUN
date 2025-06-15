class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // {
        //      up-left -> 0, 
        //      up -> 1, 
        //      up-right -> 2, 
        //      right -> 3, 
        //      down-right -> 4, 
        //      down -> 5, 
        //      down-left -> 6, 
        //      left -> 7
        // } 
        int[] indexes = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        int dy, dx, index;
        for (int i = 0; i < queens.length; i++) {
            if (inline(queens[i], king)) // in line with king
            {
                dy = king[1] - queens[i][1];
                dx = king[0] - queens[i][0];
                // in column
                if (dx == 0) index = dy < 0 ? 1 /* up */ : 5 /* down */;
                    // in row
                else if (dy == 0) index = dx < 0 ? 7 /* left */ : 3 /* right */;
                    // cross-up
                else if (dy < 0) index = dx < 0 ? 0 /* up-left */ : 2 /* up-right */;
                    // cross-down
                else index = dx < 0 ? 6 /* down-left */ : 4 /* down-right */;
                if (indexes[index] == -1 || NearMore(queens[i], queens[indexes[index]], king)) indexes[index] = i;
            }
        }
        // setup result
        List<List<Integer>> lists = new ArrayList<>();
        for (int i : indexes) if (i != -1) lists.add(Arrays.asList(queens[i][0], queens[i][1]));
        return lists;
    }

    public boolean inline(int[] pair1, int[] pair2) {
        return
            pair1[0] == pair2[0] || // case row eq
            pair1[1] == pair2[1] || // case col eq
            Math.abs(pair1[1] - pair2[1]) == Math.abs(pair1[0] - pair2[0]); // case cross
    }

    public boolean NearMore(int[] pair1, int[] pair2, int[] target) {
        // case raw
        if (pair1[0] == pair2[0]) return Math.abs(target[1] - pair1[1]) < Math.abs(target[1] - pair2[1]);
        // case column
        if (pair1[1] == pair2[1]) return Math.abs(target[0] - pair1[0]) < Math.abs(target[0] - pair2[0]);
        // case cross
        return  // dy_1^2 + dx_1^2 < dy_0^2 + dx_0^2
            Math.pow(target[1] - pair1[1], 2) + Math.pow(target[0] - pair1[0], 2) <
            Math.pow(target[1] - pair2[1], 2) + Math.pow(target[0] - pair2[0], 2);
    }
}

// one of the beautiful questions that i solve