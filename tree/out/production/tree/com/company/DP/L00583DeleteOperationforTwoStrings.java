package leetcode.DP;

public class L00583DeleteOperationforTwoStrings {

    public static void print(int[][] path){

        for(int[] m : path){
            for(int n : m){
                System.out.print( n + " ");
            }
            System.out.println();
        }
        System.out.println("-");
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i =1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    System.out.println(i + "  " +j);
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                print(dp);
            }
        }
        // m - dp[m][m] + n - dp[m][n]
        return m+n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "peace", word2 = "erase";
        System.out.println(minDistance(word1, word2));
    }

}
