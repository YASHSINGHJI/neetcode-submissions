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
     public boolean isValidBST(TreeNode root) {
    List<Integer> trav = dfs(root);  // In-order traversal

    for (int i = 1; i < trav.size(); i++) {
        if (trav.get(i) <= trav.get(i - 1)) {  // Not strictly increasing
            return false;
        }
    }
    return true;
}

    public List<Integer> dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
