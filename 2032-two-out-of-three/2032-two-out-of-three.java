class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int x : nums1) set1.add(x);

        for(int x : nums2) {
            if(set1.contains(x) && !list.contains(x)) list.add(x);
            set2.add(x);
        }

        for(int x : nums3) {
            if((set1.contains(x) || set2.contains(x)) && !list.contains(x)) list.add(x);
        } 

        return list; 
    }
}