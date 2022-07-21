package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class A031_demolitonRobot {

    public static int demolitionRobot(int[][]grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean [n][m];

        int minD = Integer.MAX_VALUE;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

        q.add(new int []{0,0});
        visited[0][0] =true;
        while(!q.isEmpty())
        {
            int[] cur = q.remove();
            for(int[] d : directions)
            {
                int nX = cur[0]+d[0];
                int nY = cur[1]+d[1];

                if(nX<0|| nY<0 || nX>=n || nY>=m || grid[nX][nY]==0)
                    continue;

                if(grid[nX][nY]==9)
                    minD = Math.min(minD, grid[cur[0]][cur[1]]);

                if(grid[nX][nY]==1 && !visited[nX][nY])
                {
                    grid[nX][nY]=  grid[cur[0]][cur[1]]+1;
                    visited[nX][nY]= true;
                    q.add(new int[]{nX, nY});
                }
            }
        }

        return minD;
    }

    public static void main(String[] args) {

    }
}
