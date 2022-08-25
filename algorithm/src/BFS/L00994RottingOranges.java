package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hans
 */
public class L00994RottingOranges {
    public int orangesRotting(int[][] grid) {

        int res = 0, m = grid.length, n = grid[0].length, freshLeft = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1,0}, {0,1}, {1,0},{0,-1}};

        // count fresh fruits and push the rotten index to queue

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] == 1){
                    freshLeft++;
                }else if( grid[i][j] == 2 ){
                    queue.add( new int[] {i,j} );
                }
            }
        }


        while( !queue.isEmpty() && freshLeft >0){

            for(int i=queue.size(); i > 0; i--){

                int[] cur = queue.peek();
                queue.poll();

                for(int k=0; k < 4; k++){
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];

                    if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1){
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.add(new int[] {x, y});
                    freshLeft--;

                }

            }
            res++;

        }

        return freshLeft > 0 ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};


    }


}
