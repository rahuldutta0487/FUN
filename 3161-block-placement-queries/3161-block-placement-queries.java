import java.util.*;

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        NavigableMap<Integer, Integer> startEnd = new TreeMap<>();
        startEnd.put(0, 50000);
        NavigableMap<Integer, NavigableSet<Integer>> lenStart = new TreeMap<>();
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(0);
        lenStart.put(50000, set);
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                int x = query[1];
                int prev = startEnd.floorKey(x);
                int end = startEnd.get(prev);
                startEnd.put(prev, x);
                startEnd.put(x, end);
                NavigableSet<Integer> starts = lenStart.get(end - prev);
                if (starts.size() == 1) {
                    lenStart.remove(end - prev);
                } else {
                    starts.remove(prev);
                }
                lenStart.computeIfAbsent(x - prev, a -> new TreeSet<>()).add(prev);
                lenStart.computeIfAbsent(end - x, a -> new TreeSet<>()).add(x);
            } else {
                int x = query[1];
                int sz = query[2];
                Integer size = lenStart.ceilingKey(sz);
                boolean found = false;
                while (size != null) {
                    int firstStart = lenStart.get(size).first();
                    if (x - firstStart >= sz) {
                        found = true;
                        result.add(true);
                        break;
                    }
                    size = lenStart.higherKey(size);
                }
                if (!found) {
                    result.add(false);
                }
            }
        }
        return result;
    }
}