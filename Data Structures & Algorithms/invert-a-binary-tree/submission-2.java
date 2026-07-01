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
     public TreeNode invertTree(TreeNode root) {
     Queue<TreeNode> q=new LinkedList<>();   
     if(root==null)
     return null;
        q.offer(root);
        while (!q.isEmpty()) {
           if(q.peek().right!=null){q.offer(q.peek().right);}
           if(q.peek().left!=null){q.offer(q.peek().left);}
           TreeNode temp=q.peek().left;
           q.peek().left=q.peek().right;
           q.peek().right=temp;
           q.poll();
        }
        return root;

        
    }
}
