class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ratioAndQuality = new double[n][2]; // {ratio, quality}
        for (int i = 0; i < n; i++) {
            ratioAndQuality[i][0] = (double) wage[i] / quality[i];
            ratioAndQuality[i][1] = quality[i];
        }
        
        Arrays.sort(ratioAndQuality, (a, b) -> Double.compare(a[0], b[0]));
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double minCost = Double.MAX_VALUE;
        double qualitySum = 0;
        
        for (double[] rq : ratioAndQuality) {
            qualitySum += rq[1];
            maxHeap.offer(rq[1]);
            
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * rq[0]);
            }
        }
        
        return minCost;
    }
}