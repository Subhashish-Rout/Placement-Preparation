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
        helper(root);
    }
    // faith rakhna h ki left apna kaam kar lega and right apna kaam karlega to mujhe call k baas bas left k end mein right lagana h
    
    // kavi v transformation ka question mile to faith use karna
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        helper(root.right);
        TreeNode xr = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!= null){
            root= root.right;
        }
        root.right = xr;
    }
}