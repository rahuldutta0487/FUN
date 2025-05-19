class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0;
        for(List<Integer> list : points){
            if(list.get(0) == location.get(0) && list.get(1) == location.get(1)){
                same++;
            }
        }
        double[] theta = new double[points.size() - same];
        int ind = 0;
        double px = (double)location.get(0);
        double py = (double)location.get(1);
        for(List<Integer> list : points){
            if(!(list.get(0) == location.get(0) && list.get(1) == location.get(1))){
                double lx = (double)list.get(0) - px;
                double ly = (double)list.get(1) - py;
                theta[ind] = Math.atan2(ly, lx);
                ind++;
            }
            
        }
        Arrays.sort(theta);
        double rad = Math.toRadians((double)angle);
        double[] twice = new double[theta.length*2];
        for(int i = 0; i < twice.length; i++){
            twice[i] = theta[i%theta.length];
        }
        for(int i = theta.length; i < twice.length; i++){
            twice[i] += 2.0 * Math.PI;
        }
        int max = 0;
        int lead = 0;
        int trail = 0;
        while(lead < twice.length){
            if(lead == trail){
                max = Math.max(max, 1);
                lead++;
                continue;
            }
            if(twice[lead] - twice[trail] <= rad){
                max = Math.max(max, lead - trail + 1);
                lead++;
            }else{
                trail++;
            }
        }
        return max+same;
    }
}