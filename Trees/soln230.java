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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        
        if(root == null){
            return -1;
        }
        
        TreeNode current = root;
        
        while(current !=null || !stack.isEmpty()){
            while(current!=null){
                stack.add(current);
                current=current.left;
            }
            if(--k==0){
                current = stack.pop();
                return current.val;
            }
            current = stack.pop();
            output.add(current.val);
            current = current.right;
        }
        
        return -1;
    
    }
}
