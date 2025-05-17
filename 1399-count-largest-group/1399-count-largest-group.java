class Solution {
    public int countLargestGroup(int n) {
        int maxSize = 0, ctn = 0;
        int[] groups = new int[37];

        while(n > 0){
            groups[sumDig(n--)]++;
        }

        for(int size : groups){
            if(size == maxSize) ctn++;
            else if(size > maxSize){ 
                maxSize = size; 
                ctn = 1;
            }
        }

        return ctn;
    }

    private int sumDig(int n ){
        return n > 0 ? sumDig(n/10) + n%10 : 0;
    }
}