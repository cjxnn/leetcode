/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class Solution{
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> readNums = new HashMap(nums.length - 1);
		int[] result = new int[2];

		for(int i = 0; i < nums.length; i++){
			if(readNums.containsKey(target - nums[i])){
				result[0] = readNums.get(target - nums[i]);
				result[1] = i;
				break;
			}
			else{
				readNums.put(nums[i], i);
			}
		}

		return result;
	}
}
