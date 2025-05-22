import java.util.Arrays;

class Solution {
    public int racecar(int targetPosition) {
        int[] stepsToReach = new int[targetPosition + 1];
        Arrays.fill(stepsToReach, Integer.MAX_VALUE);
        stepsToReach[0] = 0;

        for (int currentPos = 1; currentPos <= targetPosition; currentPos++) {
            int maxShift = Integer.toBinaryString(currentPos).length();
            
            if (currentPos == (1 << maxShift) - 1) {
                stepsToReach[currentPos] = maxShift;
            } else {
                for (int subStep = 0; subStep < maxShift - 1; subStep++) {
                    int adjustment = currentPos - ((1 << (maxShift - 1)) - (1 << subStep));
                    stepsToReach[currentPos] = Math.min(stepsToReach[currentPos], stepsToReach[adjustment] + maxShift - 1 + 2 + subStep);
                }
                if ((1 << maxShift) - 1 > currentPos) {
                    stepsToReach[currentPos] = Math.min(stepsToReach[currentPos], stepsToReach[(1 << maxShift) - 1 - currentPos] + maxShift + 1);
                }
            }
        }
        return stepsToReach[targetPosition];
    }
}