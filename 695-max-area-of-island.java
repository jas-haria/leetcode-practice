// https://leetcode.com/problems/max-area-of-island/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getIslandArea(grid, i , j));
                }
            }
        }
        return maxArea;
    }
    
    private int getIslandArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += getIslandArea(grid, i - 1, j);
        area += getIslandArea(grid, i + 1, j);
        area += getIslandArea(grid, i, j - 1);
        area += getIslandArea(grid, i, j + 1);
        return area;
    }
}