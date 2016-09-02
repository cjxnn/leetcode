/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
 
 public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        else{
            int max = 0;
            int[][] results = new int[matrix.length][matrix[0].length];
            
            for (int i = 0; i < matrix[0].length; i++){
                results[0][i] = matrix[0][i] - '0';
                max = Math.max(max, results[0][i]);
            }
            
            for (int i = 1; i < matrix.length; i++){
                results[i][0] = matrix[i][0] - '0';
                max = Math.max(max, results[i][0]);
                
            }
            
            for (int i = 1; i < matrix.length; i++){
                for (int j = 1; j < matrix[0].length; j++){
                    if (matrix[i][j] == '0'){
                        results[i][j] = 0;
                    }
                    else{
                        results[i][j] = Math.min(results[i - 1][j - 1], Math.min(results[i][j - 1], results[i - 1][j])) + 1;
                        max = Math.max(max, results[i][j]);
                    }
                }
            }
            
            return max * max;
        }
    }
}