/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example: Given binary tree [1,null,2,3],
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new ArrayList();
        Deque<TreeNode> cache = new LinkedList();
        cache.addFirst(root);
        while(!cache.isEmpty()){
            root = cache.removeFirst();
            result.add(root.val);
            if (root.right != null)
                cache.addFirst(root.right);              

            if (root.left != null)
                cache.addFirst(root.left);
        }

        return result;
    }
}
