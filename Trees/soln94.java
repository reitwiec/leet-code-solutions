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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        
        if(root==null){
            return output;
        }
        
        TreeNode current = root;
        
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.add(current);
                current = current.left;
            }
            
            current = stack.pollLast();
            output.add(current.val);
            current = current.right;
            
        }
        return output;
    }
}
