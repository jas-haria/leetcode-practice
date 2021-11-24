// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        int count = uniquePaths(m - 1, n, dp) + uniquePaths(m, n - 1, dp);
        return count;
    }
    
    private int uniquePaths(int m, int n, int[][] dp) {
        if (m < 1 || n < 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (dp[m-1][n-1] == -1) {
            dp[m-1][n-1] = uniquePaths(m - 1, n, dp) + uniquePaths(m, n - 1, dp);
        }
        return dp[m-1][n-1];
    }
}