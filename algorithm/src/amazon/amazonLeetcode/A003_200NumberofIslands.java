package amazonLeetcode;

import java.util.LinkedList;
import java.util.Queue;

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

    public static int numIslandsBFS(char[][] grid){
        if(grid == null || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length, res=0;

        boolean[][] visited = new boolean[row][col];

        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(grid[i][j] == '0' || !visited[i][j]) continue;
                res++;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i * col + j);
                while(!queue.isEmpty()){

                    int t = queue.peek();
                    queue.poll();
                    for(int k=0; k < 4; k++){
                        int x = t/col+ dirX[k], y = t%col+dirY[k];
                        if(x < 0 || x >= row || y < 0 || y>=col || grid[x][y] == '0' || visited[x][y]) continue;
                        visited[x][y]=true;
                        queue.add(x * col + y);
                    }


                }

            }
        }

        return res;
    }




    public static void main(String[] args) {

    }
}
