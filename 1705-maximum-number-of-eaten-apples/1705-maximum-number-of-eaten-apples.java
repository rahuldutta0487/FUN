class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int count = 0;
        int day = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int n = apples.length;

        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && day == heap.peek()[0]) heap.poll();
    
            int t = apples[i];
            int exp = days[i];

            if (t != 0 && exp != 0) heap.add(new int[]{exp + day, t});
            if (!heap.isEmpty()) {
                int[] arr = heap.remove();
                arr[1]--;
                if (arr[1] != 0) heap.add(arr);
                count++;
            }

            day++;
        }

        while (!heap.isEmpty()) {
            while (!heap.isEmpty() && day == heap.peek()[0]) heap.poll();

            if (!heap.isEmpty()) {
                int[] arr = heap.remove();
                arr[1]--;
                if (arr[1] != 0) heap.add(arr);
                count++;
            }

            day++;
        }

        return count;
    }
}