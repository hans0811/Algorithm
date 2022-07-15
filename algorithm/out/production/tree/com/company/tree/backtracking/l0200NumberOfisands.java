package com.hans.tree.backtracking;

/**
 * @author hans
 */
public class l0200NumberOfisands {

    public static int[][] d = new int[][]{{-1,0}, {0,1},{1,0},{0,-1}};
    public static int m,n;
    public static boolean[][] visited;

    public static boolean inArea( int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // no basic case because x,y is valid and grid[x][y] is not visited yet.
    public void dfs(char[][] grid, int x, int y){

        visited[x][y]=  true;

        for(int i=0; i<4; i++){
            int newX = x + d[i][0], newY = y + d[i][1];

            if(inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1'){
                dfs( grid, newX, newY);
            }

        }
        return;
    }

    public int numIslands(char[][] grid) {

        m = grid.length;
        if(m==9) return 0;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j < n; j++){
                if( grid[i][j] ==  '1' && !visited[i][j]){
                    res++;
                    // find first land
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
}
