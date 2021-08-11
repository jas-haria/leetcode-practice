// https://leetcode.com/problems/intersection-of-two-arrays/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        int[] result;
        if (set1.size() < set2.size()) {
            result = getIntersection(set1, set2);
        }
        else {
            result = getIntersection(set2, set1);
        }
        return result;
    }
    
    private int[] getIntersection(Set<Integer> smaller, Set<Integer> larger) {
        int[] result = new int[smaller.size()];
        int intersectionIndex = 0;
        for (int i: smaller) {
            if (larger.contains(i)) {
                result[intersectionIndex] = i;
                intersectionIndex++;
            }
        }
        return Arrays.copyOf(result, intersectionIndex);
    }
}