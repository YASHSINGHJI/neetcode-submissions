/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        
        if (p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return helper(root.right, p, q);
        }
        
        return root;
    }
}
