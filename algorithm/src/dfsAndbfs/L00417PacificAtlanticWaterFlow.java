package algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L00417PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] seenP = new boolean[m][n];
        boolean[][] seenA = new boolean[m][n];

        for ( int i=0; i < m; i++ ){
            dfs(heights, i, 0, 0, seenP);
            dfs(heights, i, n-1, 0, seenA);
        }

        // (0,0) (1, 0), (2, 0), (3, 0), (4, 0)
        // (0,4) (1, 4

        for ( int j = 0; j < n; j++ ){
            dfs(heights, 0, j, 0, seenP);
            dfs(heights, m-1, j, 0, seenA);
        }

        for( int i=0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (seenA[i][j] && seenP[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }

        return ans;
    }

    public static void dfs(final int[][] heights, int i, int j, int h, boolean[][] seen){
        if( i < 0 || i == heights.length || j < 0 || j == heights[0].length ) return;

        if( seen[i][j] || heights[i][j] < h) return;

        seen[i][j] = true;

        dfs(heights, i + 1, j, heights[i][j], seen);
        dfs(heights, i - 1, j, heights[i][j], seen);
        dfs(heights, i, j + 1, heights[i][j], seen);
        dfs(heights, i, j - 1, heights[i][j], seen);
    }

    public static void main(String[] args) {
        int[][] map = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        pacificAtlantic(map);
    }


}
