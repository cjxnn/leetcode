/**
 * Given a complete binary tree, count the number of nodes.
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        int height = 0;
        TreeNode head = root;
        while(head.left != null){
            head = head.left;
            height++;
        }

        int answer = (1 << height + 1) - 1;
        
        int h = 0;
        while (root != null){
            head = root.right;
            h = 0; 
            
            while (head != null){
                head = head.left;
                h++;
            }

            if (h == height){
                root = root.right;
            }
            else {
                root = root.left;
                answer -= 1 << (height - 1);
            }
            
            height--;
        }
        
        return answer;
    }