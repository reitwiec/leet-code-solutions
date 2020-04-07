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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        
        Stack<TreeNode> stack1 = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        
        Stack<TreeNode> stack2 = new Stack<>();
        LinkedList<Integer> output1 = new LinkedList<>();
        
        stack1.add(root1);
         stack2.add(root2);
        
        while(!stack1.isEmpty()){
            TreeNode currentNode = stack1.pop();
            if(currentNode.left==null && currentNode.right==null) output.add(currentNode.val);
            if(currentNode.right!=null) stack1.add(currentNode.right);
            if(currentNode.left!=null) stack1.add(currentNode.left);
        }
        
        while(!stack2.isEmpty()){
            TreeNode currentNode = stack2.pop();
            if(currentNode.left==null && currentNode.right==null) output1.add(currentNode.val);
            if(currentNode.right!=null) stack2.add(currentNode.right);
            if(currentNode.left!=null) stack2.add(currentNode.left);
        }
        
        if(output.size()!=output1.size()) return false;
        
        while(!output.isEmpty()){
            if(output.pollLast()!=output1.pollLast()) return false;
        }
        
        return true;
    }
}
