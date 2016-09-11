/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *   1           <---
 *  / \
 * 2   3         <---
 *  \   \
 *   5   4       <---
 * You should return [1, 3, 4].
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    private int level = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList();
        addRightNode(root, 0, answer);
        return answer;
    }
    
    private void addRightNode(TreeNode node, int height, List<Integer> answer){
        if (node == null)
			return;
			
        if (height == level){
            answer.add(node.val);
            level++;
        }
        
        addRightNode(node.right, height + 1, answer);
        addRightNode(node.left, height + 1, answer);
    }
}