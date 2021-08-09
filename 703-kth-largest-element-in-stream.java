// https://leetcode.com/problems/kth-largest-element-in-a-stream/
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {
    
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int n: nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() == k) {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        else {
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}