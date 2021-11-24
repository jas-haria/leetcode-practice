// https://leetcode.com/problems/unique-paths-ii
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m < 1 || n < 1 || obstacleGrid[obstacleGrid.length-m][obstacleGrid[0].length - n] == 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        int count = uniquePaths(m - 1, n, dp, obstacleGrid) + uniquePaths(m, n - 1, dp, obstacleGrid);
        return count;
    }
    
    private int uniquePaths(int m, int n, int[][] dp, int[][] obstacleGrid) {
        if (m < 1 || n < 1 || obstacleGrid[obstacleGrid.length-m][obstacleGrid[0].length - n] == 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (dp[m-1][n-1] == -1) {
            dp[m-1][n-1] = uniquePaths(m - 1, n, dp, obstacleGrid) + uniquePaths(m, n - 1, dp, obstacleGrid);
        }
        return dp[m-1][n-1];
    }
}