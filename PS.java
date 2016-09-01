/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
 
 public class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        
        int i = 0;
        while(++i * i <= n) {
            for(int j = i * i; j <= n; j++)
                memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
        }
        
        return memo[n];
    }
}