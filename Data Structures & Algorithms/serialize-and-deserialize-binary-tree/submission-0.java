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

public class Codec {

      StringBuilder sb;
    int i;

    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        dfs(root);
        return sb.toString();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
        return;
    }

    public TreeNode deserialize(String data) {
        i = 0;
        String[] val = data.split(",");
        return dfs(val);
    }

    public TreeNode dfs(String[] val) {
        if (val[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val[i]));
        i++;
        root.left = dfs(val);
        root.right = dfs(val);
        return root;
    }

}
