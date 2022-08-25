package Dynamic;

import java.util.Arrays;

/**
 * @author hans
 */
public class L00221MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] sum = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i < matrix.length; i++){
            int cur = 0;
            for(int j=0; j < matrix[0].length; j++){
                cur += matrix[i][j] - '0';
                sum[i+1][j+1] = cur + sum[i][j+1];
            }
        }

        for( int len=Math.min(matrix.length, matrix[0].length); len > 0; len--){
            for(int i=0; (i+len) <= matrix.length; i++){
                for(int j=0; (j+len) <= matrix[0].length; j++){
                    if (sum[i+len][j+len] + sum[i][j] - sum[i][j+len] - sum[i+len][j] == len * len) return len * len;
                }
            }
        }


        for(int[] a : sum){
            System.out.println(Arrays.toString(a));
        }


        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {{'1','0','1','0','0'},
                                        {'1','0','1','1','1'},
                                        {'1','1','1','1','1'},
                                        {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));

    }

}
