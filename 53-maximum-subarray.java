// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int continuousSum = nums[0];
        int maxSum = continuousSum;
        for (int i = 1; i < nums.length; i++) {
            if (continuousSum + nums[i] >= nums[i]) {
                continuousSum += nums[i];
                maxSum = Math.max(maxSum, continuousSum);
            }
            else {
                continuousSum = nums[i];
                maxSum = Math.max(maxSum, continuousSum);
            }
        }
        return maxSum;
    }
}