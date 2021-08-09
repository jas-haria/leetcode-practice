// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] + a[1] - b[0] - b[1]);
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 == 0 || n2 == 0 || k == 0) return new ArrayList<>();
        for (int i = 0; i < Math.min(n1, k); i++) {
            minHeap.add(new int[] {nums1[i], nums2[0], 0});
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n1*n2, k); i++) {
            int[] min = minHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(min[0]);
            list.add(min[1]);
            result.add(list);
            if (min[2] < n2 - 1) {
                minHeap.add(new int[] {min[0], nums2[min[2] + 1], min[2] + 1});
            }
        }
        return result;
    }
}