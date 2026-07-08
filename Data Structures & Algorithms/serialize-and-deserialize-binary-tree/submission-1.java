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

    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        dfs(root.left);
        dfs(root.right);
    }

    int index = 0;

    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        index = 0;

        return build(arr);
    }

    private TreeNode build(String[] arr) {

        if (arr[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}
