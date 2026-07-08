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
    public int res=Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
     helper(root);  
     return res;      
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int leftmax=helper(root.left);
        int rightmax=helper(root.right);
        leftmax=Math.max(leftmax, 0);
        rightmax=Math.max(rightmax, 0);
        int val=root.val+leftmax+ rightmax;
        res=Math.max(res, val);
    return root.val+Math.max(rightmax,leftmax);
    }
}
