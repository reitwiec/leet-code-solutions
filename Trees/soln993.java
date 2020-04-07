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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        int p1=-1;
        int p2=-1;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            
            if(currentNode.right!=null){
                if(currentNode.right.val==x) {p1=currentNode.val;}
                if(currentNode.right.val==y) {p2=currentNode.val;}
                stack.add(currentNode.right);
            }
            
            if(currentNode.left!=null){
                if(currentNode.left.val==x) {p1=currentNode.val;}
                if(currentNode.left.val==y) {p2=currentNode.val;}
                stack.add(currentNode.left);
            }   
        }
        System.out.println(p1+" "+p2);
        if(p1==-1||p2==-1) return false;
        
        return ((level(root, x, 0)) == level(root, y, 0) && p1!=p2);
    }
    
    int level(TreeNode node, int target, int level) {
    if (node == null) {
        return -1;
    }
    if (node.val == target) {
        return level;
    }
    int l = level(node.left, target, level + 1);
    if (l != -1) {
        return l;
    } else {
        return level(node.right, target, level + 1);
    }
}
}
