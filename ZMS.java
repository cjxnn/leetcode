/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
 
 public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isZero = false;
        int zeroRow = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++){
        	isZero = false;
        	for(int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			isZero = true;
        			for (int k = 0; k < i; k++)
        				matrix[k][j] = 0;
        		}
        		
        		if (i > 0 && matrix[i-1][j] == 0)
        			matrix[i][j] = 0;
        			
        		if (zeroRow == i - 1) {
        			matrix[zeroRow][j] = 0;
        		}
        	}
        	
        	if (isZero)
        	    zeroRow = i;
        }
        
        if (zeroRow + 1 == matrix.length) {
			for(int i = 0; i < matrix[0].length; i++)
				matrix[zeroRow][i] = 0;
        }
    }
}