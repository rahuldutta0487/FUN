class Solution {
    public boolean judgePoint24(int[] cards) {
        for(int i = 0; i < cards.length - 1; i++){
            for(int j = i + 1; j < cards.length; j++){
                if(i != j && is24Possible(cards, ((1<<i)|(1<<j)) , cards[i]*1d, cards[j]*1d))  return true;
            }
        }
        return false;
    }
    private boolean is24Possible(int []cards, int isUsed, double val1, double val2){
        if(isUsed == 15)    return (Math.abs(val1 + val2 - 24d) <= 0.1 || Math.abs(val1 - val2 - 24d) <= 0.1 || Math.abs((val1 / val2) - 24) <= 0.1 || Math.abs((val2 / val1) - 24) <= 0.1 || Math.abs((val1 * val2) - 24) <= 0.1);
        for(int j = 0; j < cards.length; j++){
            if((isUsed&(1 << j)) == 0){
                for(double val[]: getAllPossibleRes(val1, val2, cards[j])){
                    if(is24Possible(cards, (isUsed|(1 << j)), val[0], val[1]))    return true;
                }
            }
        }
        return false;
    }
    private List<double[]> getAllPossibleRes(double val1, double val2, int currVal){
        List<double []> res = new ArrayList<>();
        res.add(new double[]{val1 + currVal, val2});
        res.add(new double[]{val1 - currVal, val2});
        res.add(new double[]{currVal - val1, val2});
        res.add(new double[]{val1 * currVal, val2});
        if(val1 != 0d)    res.add(new double[]{currVal / val1, val2});
        
        if(currVal != 0){
            res.add(new double[]{val1 / currVal, val2});
            res.add(new double[]{val1, val2 / currVal});
        }
        
        res.add(new double[]{val1, val2 + currVal});
        res.add(new double[]{val1, val2 - currVal});
        res.add(new double[]{val1, currVal - val2});
        res.add(new double[]{val1, val2 * currVal});
        if(val2 != 0d)      res.add(new double[]{val1,  currVal / val2});

        return res;
    }  
}