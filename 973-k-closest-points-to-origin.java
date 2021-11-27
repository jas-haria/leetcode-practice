//https://leetcode.com/problems/k-closest-points-to-origin
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, (a, b) -> 
                                            b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
        for (int[] point: points) {
            if (maxHeap.size() < K)
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[K][];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }
        return result;
    }   
}