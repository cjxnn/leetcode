/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
 
 public class Solution {
    public int firstUniqChar(String s) {
        char[] string = s.toCharArray();
        int[] count = new int[26];
        
        for(int i : string) count[i - 'a']++;
        for(int i = 0; i < string.length; i++)
            if(count[string[i] - 'a'] == 1) return i;
            
        return -1;
    }
}