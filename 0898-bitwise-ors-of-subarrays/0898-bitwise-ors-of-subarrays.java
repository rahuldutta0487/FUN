class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet();
        Set<Integer> curr = new HashSet();
        curr.add(0);
        for (int i: A) {
            Set<Integer> curr2 = new HashSet();
            for (int y: curr)
                curr2.add(i | y);
            curr2.add(i);
            curr = curr2;
            res.addAll(curr);
        }
        return res.size();
    }
}