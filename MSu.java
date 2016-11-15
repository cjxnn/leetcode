/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int running = nums[0], max = running;
        
        for (int i = 1; i < nums.length; i++){
            running = running > 0 ? running + nums[i] : nums[i];
            if (running > max) max = running;
        }
        
        return max;
    }
}

public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1)[1];
    }
    
    private int[] maxSubArray(int[] nums, int s, int f){
        if (s == f){
            return new int[] {nums[s], nums[s], nums[s], nums[s]};
        }
        else{
            int mid = (s + f)/2;
            int[] a = maxSubArray(nums, s, mid);
            int[] b = maxSubArray(nums, mid + 1, f);
            
            a[0] = Math.max(a[0], a[3] + b[0]);

            a[1] = Math.max(a[1], b[1]);
            if (a[2] > 0 && b[0] > 0)
                a[1] = Math.max(a[1], a[2] + b[0]);
            else
                a[1] = Math.max(a[1], Math.max(a[2], b[0]));
            
            a[2] = Math.max(b[2], b[3] + a[2]);
            
            a[3] += b[3];
            
            return a;
        }
    }
}
