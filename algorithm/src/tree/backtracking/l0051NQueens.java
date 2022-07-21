package tree.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hans
 */
public class l0051NQueens {

    public static List<List<String>> res = new LinkedList<>();
    public static boolean[] col, dia1, dia2;
    // create recursion
    // Save queen in the row
    public static void putQueen(int n, int index, ArrayList<Integer> row){

        if(index == n){
            res.add( generateBoard(n, row));
            return;
        }

        for(int i=0; i < n; i++){

            // put queen which in index into the i
            if( !col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                row.add(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n, index+1, row);
                // backtrack
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
                row.remove(row.size()-1);
            }
        }

        return;
    }

    public static List<String> generateBoard(int n, ArrayList<Integer> row){

        List<String> s = new LinkedList<>();

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int order = row.get(i);
            for(int j=0; j<n; j++){
                if(j==order){
                    sb.append("Q");
                }
                sb.append(".");
            }
            s.add(sb.toString());
        }
        return s;

    }

    public static List<List<String>> solveNQueens(int n) {

        col = new boolean[n];

        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];

        ArrayList<Integer> row = new ArrayList<>();
        putQueen(n, 0, row);
        System.out.println();
        return res;

    }

    public static void main(String[] args) {
        solveNQueens(4);
    }

}
