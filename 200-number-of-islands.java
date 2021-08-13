// https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    addIsland(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void addIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
             || grid[i][j] == '0') return;
        grid[i][j] = '0';
        addIsland(grid, i - 1, j);
        addIsland(grid, i, j - 1);
        addIsland(grid, i + 1, j);
        addIsland(grid, i, j + 1);
    }
}