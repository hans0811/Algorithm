package com.company.tree.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0078WordSearch {

    public static int[][] d = new int[][]{{-1,0}, {0,1},{1,0},{0,-1}};
    public static int m,n;
    public static boolean[][] visited;

    public static boolean inArea( int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // From board[startx][starty], looking for word[index...word.size()]
    public static boolean serachWord( char[][] board, String word, int idx, int startx, int starty){

        System.out.println( "index: " + idx +" " + startx + " " + starty);
        if(idx == word.length() -1)
            return board[startx][starty] == word.charAt(idx);

        if(board[startx][starty] == word.charAt(idx)){
            visited[startx][starty] = true;

            // from startX, startY, looking for word in clock-wise
            for(int i=0; i<4; i++){
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];

                if( inArea(newx, newy) && !visited[newx][newy]){
                    if(serachWord(board, word, idx+1, newx, newy)){
                        return true;
                    }
                }
            }

            visited[startx][starty] = false;
        }

        return false;
    }

    public static boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j < board[i].length; j++){
                if( serachWord(board, word, 0, i, j) ) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'A', 'B', 'C', 'E'}, {'S','F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        exist(a, "SEE");
    }
}
