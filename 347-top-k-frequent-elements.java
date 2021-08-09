// https://leetcode.com/problems/top-k-frequent-elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int frequency;
        for (int n: nums) {
            frequency = map.getOrDefault(n, 0);
            frequency++;
            map.put(n, frequency);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> 
                                                            map.get(a) - map.get(b));
        for (Integer n: map.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while(minHeap.size() > 0) {
            result[i] = minHeap.poll();
            i++;
        }
        return result;
    }
}