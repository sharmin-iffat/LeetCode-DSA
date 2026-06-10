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
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();

        dfs(root, list);

        TreeNode curr = list.get(0);

        int i=1;
        while(i<list.size()){
            curr.left = null;
            curr.right = list.get(i);
            curr = curr.right;
            i++;
        }
        curr.left = null;
        curr.right = null;

    }
    void dfs(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;

        list.add(root);

        dfs(root.left, list);
        dfs(root.right, list);
    }
}