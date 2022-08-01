package amazonLeetcode;

public class A003_200NumberofIslands {

    public static boolean[][] visited;

    public static int numIslands(char[][] grid) {

        if( grid == null || grid[0] == null) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        visited= new boolean[row][col];

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(grid[i][j] == '0' || visited[i][j]) continue;

                dfs(grid, i, j);
                res++;
            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int r, int c){

        if( r < 0 || r >= grid.length || c <0 || c >=grid[0].length
                || grid[r][c] == '0'
                || visited[r][c]) return;

        visited[r][c] = true;

        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);

    }



    public static void main(String[] args) {

    }
}
