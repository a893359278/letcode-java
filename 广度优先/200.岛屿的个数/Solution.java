class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        boolean [][] flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                flag[i][j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!flag[i][j] && grid[i][j] != '0') {
                    bfs(grid,flag,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char [][] grid , boolean [][] flag, int i, int j) {
        if(i >= grid.length || j >= grid[0].length || i <= -1 || j <= -1) return;
        if(flag[i][j] || grid[i][j] != '1') return ;
        if(!flag[i][j]) {
             flag[i][j] = true;
             bfs(grid, flag, i+1,j);
             bfs(grid, flag, i-1,j);
             bfs(grid, flag, i,j + 1);
             bfs(grid, flag, i, j - 1);
            return;
        }
    }
}