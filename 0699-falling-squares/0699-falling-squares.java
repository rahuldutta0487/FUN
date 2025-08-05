class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int highest = 0;
        List<Integer> ans = new ArrayList();
        TreeSet<Integer> pointsOfIntrest = new TreeSet<>(); 
        Map <Integer,Integer> heights = new HashMap<>();

        for (int[] position: positions) { 
            pointsOfIntrest.add(position[0]);
            pointsOfIntrest.add(position[0] + position[1]);
        }

        for (int[] position: positions) {    
            int curRectHeight = position[1] , highestInRange = curRectHeight;

            //if another rect starts at the same start point we add it, but if the other rect ends we ignore it , thats the point of marking negative hieght     
            if (heights.getOrDefault(position[0] , 0) > 0) highestInRange += heights.get(position[0]); 

            Set<Integer> between = pointsOfIntrest.subSet(position[0] + 1, position[0] + position[1]);
            for (int last: between) highestInRange = Math.max (highestInRange, curRectHeight + Math.abs(heights.getOrDefault(last,0)));
            
            heights.put (position[0] , highestInRange);
            heights.put (position[0] + position[1] , -highestInRange);
            for (int h: between) heights.put(h ,highestInRange);

            highest = Math.max (highest,highestInRange);
            ans.add(highest);
        }
        return ans;
    }
}