package amazonLeetcode;

public class A018_WordSearch {
    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) return false;
        if (word.length() == 0) return true;
        if (board.length == 0) return false;

        int rows = board.length;
        int cols = board[0].length;

        for(int r =0; r < rows; r++){
            for(int c=0; c < cols; c++){
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int start){
        if(start == word.length()) return true;

        // r and c not over board size
        if(  !( r >= 0 && r < board.length && c >= 0 && c < board[0].length) ||
                board[r][c] != word.charAt(start)) {
            return false;
        }

        // mark visited
        board[r][c] = '*';
        boolean res = dfs(board, word, r-1, c, start+1)
                || dfs(board, word, r, c-1, start+1 )
                || dfs(board, word, r+1, c , start + 1)
                || dfs(board, word, r, c+1 , start + 1);

        board[r][c] = word.charAt(start);

        return res;
    }
}
