/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
 
public class Solution {
	public int mySqrt(int x) {
		long upper = x, lower = 0, mid = 0;
        
        while (upper > lower){
            mid = (upper + lower) /2;
            if (mid * mid < x)
                lower = mid + 1;
            else
                upper = mid;
        }
        
        
        return (int) (upper * upper > x ? upper - 1 : upper);
    }
}