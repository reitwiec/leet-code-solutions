/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return false;
        Stack<TreeNode> stack = new Stack<>();
        int match = root.val;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            if(match!=currentNode.val) return false;
            if(currentNode.left!=null) stack.add(currentNode.left);
            if(currentNode.right!=null) stack.add(currentNode.right);
        }
        return true;
    }
}
