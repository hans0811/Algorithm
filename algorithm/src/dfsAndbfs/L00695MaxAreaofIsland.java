package com.hans.dfsAndbfs;

/**
 * @author hans
 */
public class L00695MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int y = grid.length;
        int x = grid[0].length;
        int res = 0;

        for(int i=0; i < y; i++){
            for(int j=0; j < x; j++){

                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int y, int x){

        int area = 0;

        if( y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] == 1){
            // give 0 mean we alreay visited, or it will be for-loop
            grid[y][x] = 0;
            area = 1 + dfs(grid, y-1, x) + dfs(grid, y+1, x)
                    + dfs(grid, y, x-1) + dfs(grid, y, x+1);
        }

        return area;
    }

}
